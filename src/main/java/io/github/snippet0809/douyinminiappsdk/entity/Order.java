package io.github.snippet0809.douyinminiappsdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Order {

    @JSONField(name = "app_id")
    private String appid;
    @JSONField(name = "out_order_no")
    private String outOrderNo;
    @JSONField(name = "total_amount")
    private Integer totalAmount;
    private String subject;
    private String body;
    @JSONField(name = "valid_time")
    private Integer validTime;
    private String sign;
    @JSONField(name = "cp_extra")
    private String cpExtra;
    @JSONField(name = "notify_url")
    private String notifyUrl;
    @JSONField(name = "thirdparty_id")
    private String thirdpartyId;
    @JSONField(name = "store_uid")
    private String storeUid;
    @JSONField(name = "disable_msg")
    private Integer disableMsg;
    @JSONField(name = "msg_page")
    private String msgPage;
}
