package com.il210so.server.dto.response.academicInfo;

import com.il210so.server.domain.AcademicInfo;
import lombok.Getter;

@Getter
public class AcademicInfoResponse {
    private String highestEdu;
    private String schoolName;
    private String majorField;
    private String major;
    private String graduationDate;

    public AcademicInfoResponse(String highestEdu, String schoolName, String majorField, String major, String graduationDate) {
        this.highestEdu = highestEdu;
        this.schoolName = schoolName;
        this.majorField = majorField;
        this.major = major;
        this.graduationDate = graduationDate;
    }

    public AcademicInfoResponse from(AcademicInfo academicInfo) {
        return new AcademicInfoResponse(academicInfo.getHighestEdu(), academicInfo.getSchoolName(),
                academicInfo.getMajorField(), academicInfo.getMajor(), academicInfo.getGraduationDate());
    }
}
