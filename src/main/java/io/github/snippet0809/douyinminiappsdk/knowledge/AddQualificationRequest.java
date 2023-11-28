package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddQualificationRequest extends BaseRequest<AddQualificationRequest.AddQualificationResponseBody> {

    private Qualification qualification;

    public AddQualificationRequest() {
        super(DouyinApi.ADD_QUALIFICATION);
    }

    @Data
    public static class AddQualificationResponseBody {
        @JSONField(name = "object_id")
        private String objectId;
        @JSONField(name = "audit_id")
        private String auditId;
    }
}
