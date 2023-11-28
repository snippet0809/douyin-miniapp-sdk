package io.github.snippet0809.douyinminiappsdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class PushOrder {

    public static final int ORDER_STATUS_WAIT = 0;
    public static final int ORDER_STATUS_VERIFY = 4;

    @JSONField(name = "client_key")
    private String clientKey;
    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "ext_shop_id")
    private String extShopId;
    @JSONField(name = "app_name")
    private String appName;
    @JSONField(name = "open_id")
    private String openId;
    @JSONField(name = "order_detail")
    private String orderDetail;
    @JSONField(name = "order_status")
    private Integer orderStatus;
    @JSONField(name = "order_type")
    private Integer orderType;
    @JSONField(name = "update_time")
    private Long updateTime;
    private String extra;


    @Data
    public static class OrderDetail {
        @JSONField(name = "order_id")
        private String orderId;
        @JSONField(name = "create_time")
        private Long createTime;
        private String status;
        private Integer amount;
        @JSONField(name = "total_price")
        private Integer totalPrice;
        @JSONField(name = "detail_url")
        private String detailUrl;
        @JSONField(name = "item_list")
        private List<Item> itemList;

        @Data
        public static class Item {
            @JSONField(name = "item_code")
            private String itemCode;
            private String img;
            private String title;
            @JSONField(name = "sub_title")
            private String subTitle;
            private Integer amount;
            private Integer price;
        }
    }
}
