package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
public class QueryCourseRequest extends BaseRequest<QueryCourseRequest.QueryCourseResponseBody> {

    @JSONField(name = "product_ids")
    private Set<Long> productIds;

    public QueryCourseRequest() {
        super(DouyinApi.QUERY_COURSE);
    }

    @Data
    public static class QueryCourseResponseBody {
        private List<ProductInfo> products;
    }

    @Data
    public static class ProductInfo {
        @JSONField(name = "product_on_shelf")
        private Product productOnShelf;
        @JSONField(name = "product_reviewing")
        private Product productReviewing;
    }

    @Data
    public static class Product {
        @JSONField(name = "product_id")
        private Long productId;
        @JSONField(name = "product_type")
        private Integer productType;
        @JSONField(name = "common_product_info")
        private Object commonProductInfo;
        @JSONField(name = "course_info")
        private Object courseInfo;
        @JSONField(name = "product_status")
        private ProductStatus productStatus;
    }

    @Data
    public static class ProductStatus {
        private Integer status;
        @JSONField(name = "rejectReason")
        private String rejectReason;
        @JSONField(name = "latest_audit_id")
        private String latestAuditId;
    }
}
