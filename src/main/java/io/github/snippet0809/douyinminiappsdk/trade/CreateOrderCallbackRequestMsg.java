package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderCallbackRequestMsg {

    private String orderId;
    private List<Object> goods;
    private Integer totalAmount;
    private Integer discount;
    @JSONField(name = "cp_extra")
    private String cpExtra;
    @JSONField(name = "create_order_time")
    private Long createOrderTime;
    @JSONField(name = "open_id")
    private String openId;
    @JSONField(name = "phone_num")
    private String phoneNum;
    @JSONField(name = "contact_name")
    private String contactName;
    @JSONField(name = "app_id")
    private String appId;
    @JSONField(name = "union_id")
    private String unionId;
    @JSONField(name = "delivery_type")
    private Integer deliveryType;
    @JSONField(name = "price_calculation_detail")
    private Object priceCalculationDetail;
    @JSONField(name = "item_order_info_list")
    private List<ItemOrderInfo> itemOrderInfoList;

    @Data
    public static class ItemOrderInfo {
        @JSONField(name = "goods_id")
        private String goodsId;
        @JSONField(name = "goods_id_type")
        private Integer goodsIdType;
        @JSONField(name = "item_order_id")
        private String itemOrderId;
        private Integer price;
    }
}
