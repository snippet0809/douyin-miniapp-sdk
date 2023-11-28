package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class QueryCourseReviewRequest extends BaseRequest<QueryCourseReviewRequest.QueryCourseReviewResponseBody> {

    public static final int TYPE_BASE_INFO = 1;

    @JSONField(name = "product_ids")
    private Set<Long> productIds;
    @JSONField(name = "query_type")
    private Integer queryType;

    public QueryCourseReviewRequest() {
        super(DouyinApi.QUERY_COURSE_REVIEW);
    }

    @Data
    public static class QueryCourseReviewResponseBody {
        @JSONField(name = "products_review")
        private Map<String, ProductReview> productsReview;
    }

    @Data
    public static class ProductReview {
        private Course course;
        private Object fulfillment;
    }

    @Data
    public static class Course {

        public static final int STATUS_WAIT = 1;
        public static final int STATUS_SUCCESS = 2;
        public static final int STATUS_FAIL = 3;

        private Integer status;
        @JSONField(name = "reject_reason")
        private String rejectReason;
        @JSONField(name = "latest_audit_id")
        private String latestAuditId;
    }
}
