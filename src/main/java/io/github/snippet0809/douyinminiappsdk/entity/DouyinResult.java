package io.github.snippet0809.douyinminiappsdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class DouyinResult<T> {

    @JSONField(name = "err_no")
    private Integer errNo;
    @JSONField(name = "err_tips")
    private String errTips;
    private T data;


    public DouyinResult() {
    }

    public DouyinResult(boolean success) {
        this.errNo = success ? 0 : 400;
        this.errTips = success ? "success" : "business fail";
    }
}
