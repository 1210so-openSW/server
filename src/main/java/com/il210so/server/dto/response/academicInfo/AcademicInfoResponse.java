package com.il210so.server.dto.response.academicInfo;

import com.il210so.server.domain.AcademicInfo;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Year;

@Getter
public class AcademicInfoResponse {
    private String highestEdu;
    private String schoolName;
    private String majorField;
    private String major;
    private Year graduationYear;

    private AcademicInfoResponse(String highestEdu, String schoolName, String majorField, String major, Year graduationYear) {
        this.highestEdu = highestEdu;
        this.schoolName = schoolName;
        this.majorField = majorField;
        this.major = major;
        this.graduationYear = graduationYear;
    }

    public static AcademicInfoResponse from(AcademicInfo academicInfo) {
        return new AcademicInfoResponse(
                academicInfo.getHighestEdu(),
                academicInfo.getSchoolName(),
                academicInfo.getMajorField(),
                academicInfo.getMajor(),
                academicInfo.getGraduationYear());
    }
}
