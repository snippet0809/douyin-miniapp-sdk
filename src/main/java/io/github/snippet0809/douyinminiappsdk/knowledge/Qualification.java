package io.github.snippet0809.douyinminiappsdk.knowledge;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class Qualification {

    public static final int TYPE_TEACHER = 1;       // 老师
    public static final int TYPE_CORP = 2;          // 机构

    @JSONField(name = "object_type")
    private Integer objectType;
    @JSONField(name = "object_id")
    private String objectId;           // 添加资质时不需要，修改资质时需要
    @JSONField(name = "institution_qualification_info")
    private InstitutionQualificationInfo institutionQualificationInfo;
    @JSONField(name = "callback_data")
    private String callbackData;

    @Data
    public static class InstitutionQualificationInfo {

        private String name;
        @JSONField(name = "institution_introduction")
        private String institutionIntroduction;
        @JSONField(name = "company_name")
        private String companyName;
        @JSONField(name = "institution_record_name")
        private String institutionRecordName;
        @JSONField(name = "institution_scene_type")
        private String institutionSceneType;
        @JSONField(name = "institution_subject_type")
        private String institutionSubjectType;
        @JSONField(name = "legal_person_name")
        private String legalPersonName;
        @JSONField(name = "legal_person_ID_number")
        private String legalPersonIDNumber;
        @JSONField(name = "legal_person_ID_img_uris")
        private List<String> legalPersonIDImgUris;
        @JSONField(name = "institution_logo_uri")
        private String institutionLogoUri;
        @JSONField(name = "institution_trade_mark_uri")
        private String institutionTradeMarkUri;
        @JSONField(name = "img_uri")
        private String imgUri;
        private String nickname;
        @JSONField(name = "qualification_info_lst")
        private List<QualificationInfo> qualificationInfoLst;
    }

    @Data
    public static class QualificationInfo {

        public static final int TYPE_CORP = 1;  // 机构营业许可证

        private Integer type;
        @JSONField(name = "image_uris")
        private List<String> imageUris;
        @JSONField(name = "validity_date")
        private String validityDate;
        @JSONField(name = "license_id")
        private String licenseId;
    }
}
