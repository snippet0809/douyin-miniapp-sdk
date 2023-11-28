package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.snippet0809.douyinminiappsdk.DouyinApi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AddOrModifyCourseRequest extends BaseRequest<AddOrModifyCourseRequest.AddOrModifyCourseResponseBody> {

    @JSONField(name = "product_type")
    private Integer productType;
    @JSONField(name = "product_id")
    private Long productId;
    private Product product;

    public AddOrModifyCourseRequest(boolean modify) {
        super(modify ? DouyinApi.MODIFY_COURSE : DouyinApi.ADD_COURSE);
    }

    @Data
    public static class Product {
        @JSONField(name = "common_product_params")
        private CommonProductParams commonProductParams;
        @JSONField(name = "course_params")
        private CourseParams courseParams;
    }

    @Data
    public static class CommonProductParams {
        private String appid;
        @JSONField(name = "first_class")
        private Integer firstClass;
        @JSONField(name = "second_class")
        private Integer secondClass;
        private String title;
        @JSONField(name = "purchase_precaution")
        private String purchasePrecaution;
        @JSONField(name = "industry_type")
        private Integer industryType;
        @JSONField(name = "product_fulfillment_lst")
        private List<ProductFulfillment> productFulfillmentLst;
        @JSONField(name = "price_info")
        private PriceInfo priceInfo;
        @JSONField(name = "path_info_lst")
        private List<PathInfo> pathInfoLst;
        @JSONField(name = "product_detail_lst")
        private List<ProductDetail> productDetailLst;
        @JSONField(name = "anchor_info")
        private AnchorInfo anchorInfo;
        @JSONField(name = "callback_data")
        private String callbackData;
        @JSONField(name = "product_img_uri")
        private String productImgUri;
    }

    @Data
    public static class ProductFulfillment {
        @JSONField(name = "fulfillment_content")
        private FulfillmentContent fulfillmentContent;
        @JSONField(name = "fulfillment_type")
        private Integer fulfillmentType;
    }

    @Data
    public static class FulfillmentContent {
        @JSONField(name = "fulfillment_uri")
        private String fulfillmentUri;
        private String text;
        private String name;
    }

    @Data
    public static class PriceInfo {
        private String unit;
        private Integer price;
        @JSONField(name = "real_price")
        private Integer realPrice;
        @JSONField(name = "range_min_price")
        private Integer rangeMinPrice;
        @JSONField(name = "range_max_price")
        private Integer rangeMaxPrice;
    }

    @Data
    public static class PathInfo {
        private String path;
        private Map<String, String> query;
    }

    @Data
    public static class ProductDetail {
        private String text;
        @JSONField(name = "img_uri")
        private String imgUri;
        @JSONField(name = "rich_text")
        private RichText richText;
    }

    @Data
    public static class RichText {
        private String text;
    }

    @Data
    public static class AnchorInfo {
        @JSONField(name = "video_anchor_info")
        private VideoAnchorInfo videoAnchorInfo;
    }

    @Data
    public static class VideoAnchorInfo {
        @JSONField(name = "anchor_title")
        private String anchorTitle;
    }

    @Data
    public static class CourseParams {
        @JSONField(name = "teacher_id")
        private String teacherId;
        @JSONField(name = "institution_id")
        private String institutionId;
        @JSONField(name = "course_num")
        private Integer courseNum;
        @JSONField(name = "refund_label")
        private RefundLabel refundLabel;
    }

    @Data
    public static class RefundLabel {
        private Integer type;
        @JSONField(name = "day_before_use_info")
        private DayBeforeUseInfo dayBeforeUseInfo;
        @JSONField(name = "rest_not_learn_info")
        private RestNotLearnInfo restNotLearnInfo;
    }

    @Data
    public static class DayBeforeUseInfo {
        private Integer day;
    }

    @Data
    public static class RestNotLearnInfo {
        @JSONField(name = "rest_percent")
        private Integer restPercent;
    }

    @Data
    public static class UseLabel {
        @JSONField(name = "valid_date")
        private String validDate;
        @JSONField(name = "dynamic_valid_date")
        private DynamicValidDate dynamicValidDate;
    }

    @Data
    public static class DynamicValidDate {
        private Integer year;
        private Integer month;
        private Integer day;
    }

    @Data
    public static class AddOrModifyCourseResponseBody {
        @JSONField(name = "product_id")
        private Long productId;
        @JSONField(name = "audit_id")
        private String auditId;
    }
}
