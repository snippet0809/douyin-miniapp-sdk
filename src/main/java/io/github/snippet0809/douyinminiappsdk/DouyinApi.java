package io.github.snippet0809.douyinminiappsdk;

public interface DouyinApi {

    String DOMAIN = "https://developer.toutiao.com";

    // 基础能力API
    String GET_ACCESS_TOKEN = "https://developer.toutiao.com/api/apps/v2/token";
    String CODE_2_SESSION = "https://developer.toutiao.com/api/apps/v2/jscode2session";
    String CREATE_ORDER = "https://developer.toutiao.com/api/apps/ecpay/v1/create_order";
    String PUSH_ORDER = "https://developer.toutiao.com/api/apps/order/v2/push";


    // 泛知识API  沙盒环境：open-sandbox.douyin.com
    String UPLOAD_RESOURCE = "https://developer-product.zijieapi.com/product/api/upload_resource";
    String QUERY_RESOURCE_STATUS = "https://developer-product.zijieapi.com/product/api/query_resource_status";
    String ADD_QUALIFICATION = "https://developer-product.zijieapi.com/product/api/add_qualification";
    String MODIFY_QUALIFICATION = "https://developer-product.zijieapi.com/product/api/modify_qualification";
    String QUERY_QUALIFICATION = "https://developer-product.zijieapi.com/product/api/query_qualification";
    String ADD_COURSE = "https://developer-product.zijieapi.com/product/api/add";
    String MODIFY_COURSE = "https://developer-product.zijieapi.com/product/api/modify";
    String QUERY_COURSE = "https://developer-product.zijieapi.com/product/api/query";
    String QUERY_COURSE_REVIEW = "https://developer-product.zijieapi.com/product/api/query_review";

    // 交易系统API
    String SETTINGS = "/api/apps/trade/v2/settings";
    String REFUND = "/api/apps/trade/v2/create_refund";
    String HANDLE_REFUND = "/api/apps/trade/v2/merchant_audit_callback";
    String PUSH_DELIVERY = "/api/apps/trade/v2/push_delivery";
    String CREATE_SETTLE = "/api/apps/trade/v2/create_settle";
}
