package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class BaseResponse<T> {

    @JSONField(name = "err_no")
    private Integer errNo;
    @JSONField(name = "err_msg")
    private String errMsg;
    @JSONField(name = "log_id")
    private String logId;
    private T data;
}
