package io.github.snippet0809.douyinminiappsdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class CreateOrderResult {

    @JSONField(name = "order_id")
    private String orderId;
    @JSONField(name = "order_token")
    private String orderToken;
}
