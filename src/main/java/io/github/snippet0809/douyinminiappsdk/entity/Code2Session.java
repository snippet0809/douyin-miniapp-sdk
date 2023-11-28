package io.github.snippet0809.douyinminiappsdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Code2Session {

    @JSONField(name = "session_key")
    private String sessionKey;
    private String openid;
    @JSONField(name = "anonymous_openid")
    private String anonymousOpenid;
    private String unionid;
}
