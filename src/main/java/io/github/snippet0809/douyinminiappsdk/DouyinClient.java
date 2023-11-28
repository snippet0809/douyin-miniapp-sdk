package io.github.snippet0809.douyinminiappsdk;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import io.github.snippet0809.douyinminiappsdk.entity.*;
import io.github.snippet0809.douyinminiappsdk.knowledge.BaseRequest;
import io.github.snippet0809.douyinminiappsdk.knowledge.BaseResponse;
import io.github.snippet0809.douyinminiappsdk.trade.TradeRequest;
import io.github.snippet0809.douyinminiappsdk.trade.TradeResponse;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DouyinClient {

    public final String appId;
    private final String appSecret;
    public final SignHelper signHelper;

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public DouyinClient(String appId, String appSecret, SignHelper signHelper) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.signHelper = signHelper;
    }

    /**
     * 获取AccessToken
     */
    public AccessToken getAccessToken() throws IOException, DouyinException {
        Map<String, Object> body = new HashMap<>();
        body.put("appid", appId);
        body.put("secret", appSecret);
        body.put("grant_type", "client_credential");
        return post(DouyinApi.GET_ACCESS_TOKEN, body, AccessToken.class);
    }

    /**
     * 授权登录
     */
    public Code2Session getSessionByCode(String code, String anonymousCode) throws IOException, DouyinException {
        Map<String, Object> body = new HashMap<>();
        body.put("appid", appId);
        body.put("secret", appSecret);
        body.put("code", code);
        body.put("anonymous_code", anonymousCode);
        return post(DouyinApi.CODE_2_SESSION, body, Code2Session.class);
    }

    /**
     * 创建订单
     */
    public CreateOrderResult createOrder(Order order) throws DouyinException, IOException {
        order.setAppid(appId);
        String orderJson = JSONObject.toJSONString(order);
        Map<String, Object> orderMap = JSONObject.parseObject(orderJson, new TypeReference<Map<String, Object>>() {
        });
        String sign = signHelper.generateSign(orderMap);
        order.setSign(sign);
        orderJson = JSONObject.toJSONString(order);
        Map<String, Object> body = JSONObject.parseObject(orderJson, new TypeReference<Map<String, Object>>() {
        });
        return post(DouyinApi.CREATE_ORDER, body, CreateOrderResult.class);
    }

    /**
     * 创建订单-简洁
     */
    public CreateOrderResult createSimplestOrder(String outOrderNo, int totalAmount, String subject, String body, int validTime, String notifyUrl) throws DouyinException, IOException {
        Order order = new Order();
        order.setOutOrderNo(outOrderNo);
        order.setTotalAmount(totalAmount);
        order.setSubject(subject);
        order.setBody(body);
        order.setValidTime(validTime);
        order.setNotifyUrl(notifyUrl);
        return createOrder(order);
    }

    /**
     * 订单推送至抖音订单中心
     */
    public void pushOrder(PushOrder pushOrder) throws IOException, DouyinException {
        String res = post(DouyinApi.PUSH_ORDER, JSONObject.toJSONString(pushOrder));
        PushOrderResult pushOrderResult = JSONObject.parseObject(res, PushOrderResult.class);
        if (pushOrderResult.getErrCode() != 0) {
            throw new DouyinException(pushOrderResult.getErrMsg());
        }
    }


    // 发送post请求。仅用于担保支付模块
    private static <T> T post(String url, Map<String, Object> body, Class<T> tClass) throws IOException, DouyinException {
        String res = post(url, JSONObject.toJSONString(body));
        DouyinResult<T> douyinResult = JSONObject.parseObject(res, new TypeReference<DouyinResult<T>>(tClass) {
        });
        if (douyinResult.getErrNo() != 0) {
            throw new DouyinException(douyinResult.getErrTips());
        }
        return douyinResult.getData();
    }

    // 发送post请求。仅用于课程库管理
    public <T> T execute(BaseRequest<T> request) throws IOException, DouyinException {
        ParameterizedType type = (ParameterizedType) request.getClass().getGenericSuperclass();
        @SuppressWarnings("unchecked") Class<T> tClass = (Class<T>) type.getActualTypeArguments()[0];
        request.setAppid(appId);
        String url = request.url, body = JSONObject.toJSONString(request);
        String result = post(url, body);
        BaseResponse<T> response = JSONObject.parseObject(result, new TypeReference<BaseResponse<T>>(tClass) {
        });
        if (response.getErrNo() != 0) {
            throw new DouyinException(response.getErrMsg());
        }
        return response.getData();
    }

    // 发送post请求。仅用于交易系统
    public <T extends TradeResponse.TradeResponseBody> T execute(TradeRequest<T> request) throws DouyinException, IOException {
        ParameterizedType type = (ParameterizedType) request.getClass().getGenericSuperclass();
        @SuppressWarnings("unchecked") Class<T> tClass = (Class<T>) type.getActualTypeArguments()[0];
        // 计算签名放header
        String url = request.url, body = JSONObject.toJSONString(request);
        String timestamp = String.valueOf(System.currentTimeMillis());
        timestamp = timestamp.substring(0, timestamp.length() - 3);
        String nonce = String.valueOf(Math.abs(new Random().nextLong()));
        String sign;
        try {
            sign = signHelper.getSignature("POST", request.path, body, timestamp, nonce);
        } catch (Exception e) {
            throw new DouyinException("加签失败");
        }
        // Byte-Authorization: 认证类型 签名信息
        Map<String, String> signMap = new HashMap<>();
        signMap.put("appid", appId);
        signMap.put("nonce_str", nonce);
        signMap.put("timestamp", timestamp);
        signMap.put("key_version", "1");
        signMap.put("signature", sign);
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : signMap.keySet()) {
            stringBuilder.append(key).append("=").append("\"").append(signMap.get(key)).append("\"").append(",");
        }
        String signStr = stringBuilder.substring(0, stringBuilder.length() - 1);
        Map<String, String> headers = new HashMap<>();
        headers.put("Byte-Authorization", "SHA256-RSA2048" + " " + signStr);
        // 发送请求，处理响应
        String result = post(url, body, headers);
        TradeResponse<T> response = JSONObject.parseObject(result, new TypeReference<TradeResponse<T>>(tClass) {
        });
        if (response.getErrNo() != 0) {
            throw new DouyinException(response.getErrTips());
        }
        return response.getData();
    }

    // 发送post请求
    private static String post(String url, String body) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        httpPost.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
        // 发现抖音服务器响应504的概率还是蛮大的，所以这里重试三次
        CloseableHttpResponse response = null;
        boolean ok = false;
        for (int i = 0; i < 3; i++) {
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            throw new IOException("ResponseStatusCode: 400");
        }
        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
    }

    // 发送post请求
    private static String post(String url, String body, Map<String, String> headers) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        headers.forEach(httpPost::setHeader);
        httpPost.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
        CloseableHttpResponse response = null;
        // 发现抖音服务器响应504的概率还是蛮大的，所以这里重试三次
        for (int i = 0; i < 3; i++) {
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                break;
            }
        }
        // 到这里还是非200就算了，任其发生500
        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
    }
}
