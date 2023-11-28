package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadResourceRequest extends BaseRequest<UploadResourceRequest.UploadResourceResponseBody> {

    @JSONField(name = "resource_type")
    private Integer resourceType;
    @JSONField(name = "resource_url")
    private String resourceUrl;
    @JSONField(name = "callback_data")
    private String callbackData;

    public UploadResourceRequest() {
        super(DouyinApi.UPLOAD_RESOURCE);
    }

    @Data
    public static class UploadResourceResponseBody {
        @JSONField(name = "resource_uri")
        private String resourceUri;
    }
}
