package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PushDeliveryRequest extends TradeRequest<TradeResponse.TradeResponseBody> {

    @JSONField(name = "out_order_no")
    private String outOrderNo;
    @JSONField(name = "item_order_list")
    private List<Object> itemOrderList;
    @JSONField(name = "use_all")
    private Boolean useAll;
    @JSONField(name = "poi_info")
    private String poiInfo;

    public PushDeliveryRequest() {
        super(DouyinApi.PUSH_DELIVERY);
    }
}
