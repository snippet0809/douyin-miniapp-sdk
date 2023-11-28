package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandleRefundRequest extends TradeRequest<TradeResponse.TradeResponseBody> {

    @JSONField(name = "out_refund_no")
    private String outRefundNo;
    @JSONField(name = "refund_audit_status")
    private Integer refundAuditStatus;
    @JSONField(name = "deny_message")
    private String denyMessage;

    public HandleRefundRequest() {
        super(DouyinApi.HANDLE_REFUND);
    }
}
