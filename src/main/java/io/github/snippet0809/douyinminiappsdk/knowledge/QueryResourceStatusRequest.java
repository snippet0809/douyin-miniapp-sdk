package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryResourceStatusRequest extends BaseRequest<QueryResourceStatusRequest.QueryResourceStatusResponseBody> {

    @JSONField(name = "resource_uri")
    private String resourceUri;

    public QueryResourceStatusRequest() {
        super(DouyinApi.QUERY_RESOURCE_STATUS);
    }

    @Data
    public static class QueryResourceStatusResponseBody {
        @JSONField(name = "resource_uri")
        private String resourceUri;
        private Integer status;
    }
}
