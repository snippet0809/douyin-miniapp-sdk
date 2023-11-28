package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class PayCallbackRequestMsg {

    @JSONField(name = "app_id")
    private String appId;
    @JSONField(name = "status")
    private String status;
    @JSONField(name = "out_order_no")
    private String outOrderNo;
    @JSONField(name = "order_id")
    private String orderId;
    @JSONField(name = "total_amount")
    private Integer totalAmount;
    @JSONField(name = "discount_amount")
    private Integer discountAmount;

    @JSONField(name = "pay_channel")
    private Integer payChannel;
    @JSONField(name = "channel_pay_id")
    private String channelPayId;
    @JSONField(name = "cp_extra")
    private String cpExtra;
    @JSONField(name = "item_id")
    private String itemId;
    @JSONField(name = "seller_uid")
    private String sellerUid;
    @JSONField(name = "event_time")
    private Long eventTime;
    @JSONField(name = "message")
    private String message;
    @JSONField(name = "delivery_type")
    private Integer deliveryType;
}
