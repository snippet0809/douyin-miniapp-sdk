package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueryQualificationRequest extends BaseRequest<QueryQualificationRequest.QueryQualificationResponseBody> {

    @JSONField(name = "object_id_with_classifications")
    private List<ObjectIdWithClassification> objectIdWithClassifications;

    public QueryQualificationRequest() {
        super(DouyinApi.QUERY_QUALIFICATION);
    }

    @Data
    public static class ObjectIdWithClassification {

        public static final int TYPE_TEACHER = 1;       // 机构
        public static final int TYPE_CORP = 2;          // 机构


        @JSONField(name = "object_type")
        private Integer objectType;
        @JSONField(name = "object_id")
        private String objectId;
        @JSONField(name = "first_class")
        private Integer firstClass;
        @JSONField(name = "second_class")
        private Integer secondClass;
        @JSONField(name = "third_class")
        private Integer thirdClass;
    }

    @Data
    public static class QueryQualificationResponseBody {
        private List<QualificationBaseInfo> qualifications;
    }

    @Data
    public static class QualificationBaseInfo {
        @JSONField(name = "qualification_on_shelf")
        private QualificationBaseInfoItem qualificationOnShelf;
        @JSONField(name = "qualification_reviewing")
        private QualificationBaseInfoItem qualificationReviewing;
    }

    @Data
    public static class QualificationBaseInfoItem {

        public static final int STATUS_NORMAL = 1;          // 已上架
        public static final int STATUS_EXPIRY = 2;          // 已时效

        public static final int STATUS_REVIEW = 11;         // 正在审核中
        public static final int STATUS_SUCCESS = 12;        // 审核已通过
        public static final int STATUS_FAIL = 13;           // 审核未通过

        @JSONField(name = "object_type")
        private Integer objectType;
        @JSONField(name = "object_id")
        private String objectId;
        @JSONField(name = "object_name")
        private String objectName;
        @JSONField(name = "status")
        private Integer status;
        @JSONField(name = "nickname")
        private String nickname;
        @JSONField(name = "first_class")
        private Integer firstClass;
        @JSONField(name = "second_class")
        private Integer secondClass;
        @JSONField(name = "third_class")
        private Integer thirdClass;
        @JSONField(name = "fail_reason")
        private String failReason;
    }
}
