package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RefundRequest extends TradeRequest<RefundRequest.RefundResponseBody> {

    @JSONField(name = "out_order_no")
    private String outOrderNo;
    @JSONField(name = "out_refund_no")
    private String outRefundNo;
    @JSONField(name = "cp_extra")
    private String cpExtra;
    @JSONField(name = "order_entry_schema")
    private OrderEntrySchema orderEntrySchema;
    @JSONField(name = "notify_url")
    private String notifyUrl;
    @JSONField(name = "item_order_detail")
    private List<ItemOrderDetail> itemOrderDetail;

    public RefundRequest() {
        super(DouyinApi.REFUND);
    }

    @Data
    public static class OrderEntrySchema {
        private String path;
        private String params;
    }

    @Data
    public static class ItemOrderDetail {
        @JSONField(name = "item_order_id")
        private String itemOrderId;
        @JSONField(name = "refund_amount")
        private Integer refundAmount;
    }

    @Getter
    @Setter
    public static class RefundResponseBody extends TradeResponse.TradeResponseBody {
        @JSONField(name = "refund_id")
        private String refundId;
        @JSONField(name = "refund_audit_deadline")
        private Long refundAuditDeadline;
    }
}
