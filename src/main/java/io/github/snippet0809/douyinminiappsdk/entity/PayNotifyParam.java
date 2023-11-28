package io.github.snippet0809.douyinminiappsdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class PayNotifyParam {

    public static final String TYPE_PAYMENT = "payment";        // 支付成功回调
    public static final String TYPE_REFUND = "refund";          // 退款回调

    private Long timestamp;
    private String nonce;
    private String msg;
    private String type;
    @JSONField(name = "msg_signature")
    private String msgSignature;

    @Data
    public static class Msg {

        public static final String STATUS_SUCCESS = "SUCCESS";      // 成功

        private String appId;
        @JSONField(name = "cp_orderno")
        private String cpOrderno;
        @JSONField(name = "cp_extra")
        private String cpExtra;
        private String way;
        @JSONField(name = "channel_no")
        private String channelNo;
        @JSONField(name = "payment_order_no")
        private String paymentOrderNo;
        @JSONField(name = "total_amount")
        private Integer totalAmount;
        private String status;
        @JSONField(name = "item_id")
        private String itemId;
        @JSONField(name = "seller_uid")
        private String sellerUid;
        @JSONField(name = "paid_at")
        private Long paidAt;
        @JSONField(name = "order_id")
        private String orderId;
    }
}
