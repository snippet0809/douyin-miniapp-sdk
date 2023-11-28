package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSettleRequest extends TradeRequest<CreateSettleRequest.CreateSettleResponseBody> {

    @JSONField(name = "out_order_no")
    private String outOrderNo;
    @JSONField(name = "out_settle_no")
    private String outSettleNo;
    @JSONField(name = "item_order_id")
    private String itemOrderId;
    @JSONField(name = "settle_desc")
    private String settleDesc;
    @JSONField(name = "settle_params")
    private String settleParams;
    @JSONField(name = "cp_extra")
    private String cpExtra;
    @JSONField(name = "notify_url")
    private String notifyUrl;

    public CreateSettleRequest() {
        super(DouyinApi.CREATE_SETTLE);
    }

    public static class SettleParams {
        @JSONField(name = "merchant_uid")
        private String merchantUid;
        private Integer amount;
    }

    @Getter
    @Setter
    public static class CreateSettleResponseBody extends TradeResponse.TradeResponseBody {
        @JSONField(name = "settle_id")
        private String settleId;
        @JSONField(name = "inner_settle_id")
        private String innerSettleId;
    }
}
