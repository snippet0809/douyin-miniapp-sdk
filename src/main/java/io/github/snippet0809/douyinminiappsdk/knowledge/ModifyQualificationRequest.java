package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyQualificationRequest extends BaseRequest<ModifyQualificationRequest.ModifyQualificationResponseBody> {

    private Qualification qualification;

    public ModifyQualificationRequest() {
        super(DouyinApi.MODIFY_QUALIFICATION);
    }

    @Data
    public static class ModifyQualificationResponseBody {
        @JSONField(name = "product_id")
        private Long productId;
        @JSONField(name = "audit_id")
        private String auditId;
    }
}
