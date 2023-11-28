package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class BaseRequest<T> {

    public transient final String url;

    private String appid;
    @JSONField(name = "access_token")
    private String accessToken;

    public BaseRequest(String url) {
        this.url = url;
    }
}
