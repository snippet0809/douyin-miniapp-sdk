package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class CreateSettleCallbackRequestMsg {

    @JSONField(name = "app_id")
    private String appId;
    private String status;
    @JSONField(name = "order_id")
    private String orderId;
    @JSONField(name = "settle_id")
    private String settleId;
    @JSONField(name = "out_settle_no")
    private String outSettleNo;
    @JSONField(name = "cp_extra")
    private String cpExtra;
    @JSONField(name = "settle_amount")
    private Integer settleAmount;
    private Integer rake;
    private Integer commission;
    @JSONField(name = "settle_detail")
    private String settleDetail;
    @JSONField(name = "event_time")
    private Long eventTime;
    private String message;
    @JSONField(name = "item_order_id")
    private String itemOrderId;
    @JSONField(name = "is_auto_settle")
    private Boolean isAutoSettle;
}
