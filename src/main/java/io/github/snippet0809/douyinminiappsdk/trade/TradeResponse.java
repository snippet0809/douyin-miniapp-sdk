package io.github.snippet0809.douyinminiappsdk.trade;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class TradeResponse<T extends TradeResponse.TradeResponseBody> {

    @JSONField(name = "err_no")
    private Integer errNo;
    @JSONField(name = "err_tips")
    private String errTips;
    private T data;

    @Data
    public static class TradeResponseBody {
    }
}
