package io.github.snippet0809.douyinminiappsdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class PushOrderResult {

    @JSONField(name = "err_code")
    private Integer errCode;
    @JSONField(name = "err_msg")
    private String errMsg;
    private String body;
}
