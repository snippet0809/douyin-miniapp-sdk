package io.github.snippet0809.douyinminiappsdk;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.*;
import java.util.stream.Collectors;

public class SignHelper {

    public final static List<String> REQUEST_NOT_NEED_SIGN_PARAMS = Arrays.asList("app_id", "thirdparty_id", "sign", "other_settle_params");

    private final String token;
    private final String salt;
    private final PrivateKey appPrivateKey;     // 应用私钥
    private final PublicKey douyinPublicKey;    // 平台公钥

    public SignHelper(String token, String salt, PublicKey douyinPublicKey, PrivateKey appPrivateKey) {
        this.token = token;
        this.salt = salt;
        this.douyinPublicKey = douyinPublicKey;
        this.appPrivateKey = appPrivateKey;
    }

    /**
     * 担保支付-加签
     */
    public String generateSign(Map<String, Object> paramsMap) {
        List<String> paramsArr = new ArrayList<>();
        for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
            String key = entry.getKey();
            if (REQUEST_NOT_NEED_SIGN_PARAMS.contains(key)) {
                continue;
            }
            String value = entry.getValue().toString();
            value = value.trim();
            if (value.startsWith("\"") && value.endsWith("\"") && value.length() > 1) {
                value = value.substring(1, value.length() - 1);
            }
            value = value.trim();
            if ("".equals(value) || "null".equals(value)) {
                continue;
            }
            paramsArr.add(value);
        }
        paramsArr.add(salt);
        Collections.sort(paramsArr);
        StringBuilder signStr = new StringBuilder();
        String sep = "";
        for (String s : paramsArr) {
            signStr.append(sep).append(s);
            sep = "&";
        }
        return md5FromStr(signStr.toString());
    }

    /**
     * 担保支付-验签
     */
    public String generateSign(long timestamp, String nonce, String msg) {
        List<String> list = Arrays.asList(token, String.valueOf(timestamp), nonce, msg);
        String concat = list.stream().sorted().collect(Collectors.joining());
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        byte[] digestByte = mDigest.digest(concat.getBytes(StandardCharsets.UTF_8));
        StringBuilder signBuilder = new StringBuilder();
        for (byte b : digestByte) {
            signBuilder.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return signBuilder.toString();
    }

    /**
     * 交易系统-加签
     */
    public String getSignature(String method, String url, String body, String timestamp, String nonce) throws Exception {
        String buffer = method + "\n" +
                url + "\n" +
                timestamp + "\n" +
                nonce + "\n" +
                body + "\n";
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(appPrivateKey);
        sign.update(buffer.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    /**
     * 交易系统-验签
     */
    public boolean verifySign(String timestamp, String nonce, String httpBody, String signStr) throws Exception {
        String message = timestamp + "\n" + nonce + "\n" + httpBody + "\n";
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initVerify(douyinPublicKey);
        sign.update(message.getBytes(StandardCharsets.UTF_8));
        return sign.verify(Base64.getDecoder().decode(signStr.getBytes(StandardCharsets.UTF_8)));
    }


    private static String md5FromStr(String inStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] byteArray = inStr.getBytes(StandardCharsets.UTF_8);
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
