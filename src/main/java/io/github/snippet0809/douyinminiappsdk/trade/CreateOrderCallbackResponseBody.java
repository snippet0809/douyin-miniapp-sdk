package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderCallbackResponseBody extends TradeResponse.TradeResponseBody {

    @JSONField(name = "out_order_no")
    private String outOrderNo;
    @JSONField(name = "pay_expire_seconds")
    private Integer pay_expire_seconds;
    @JSONField(name = "order_entry_schema")
    private OrderEntrySchema orderEntrySchema;
    @JSONField(name = "order_valid_time")
    private List<Object> orderValidTime;
    @JSONField(name = "order_goods_info")
    private List<Object> orderGoodsInfo;
    @JSONField(name = "pay_notify_url")
    private String payNotifyUrl;
    @JSONField(name = "cp_delivery_type")
    private Integer cpDeliveryType;
    @JSONField(name = "delivery_qrcode_redirect")
    private String deliveryQrcodeRedirect;

    @Data
    public static class OrderEntrySchema {
        private String path;
        private String params;
    }
}
