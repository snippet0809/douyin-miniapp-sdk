package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SettingsRequest extends TradeRequest<TradeResponse.TradeResponseBody> {

    @JSONField(name = "create_order_callback")
    private String createOrderCallback;
    @JSONField(name = "refund_callback")
    private String refundCallback;

    public SettingsRequest() {
        super(DouyinApi.SETTINGS);
    }
}
