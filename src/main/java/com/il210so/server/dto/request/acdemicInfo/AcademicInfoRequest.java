package com.il210so.server.dto.request.acdemicInfo;

import com.il210so.server.domain.AcademicInfo;
import com.il210so.server.domain.Resume;
import com.il210so.server.domain.Member;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Year;

@Getter
public class AcademicInfoRequest {
    private String highestEdu;
    private String schoolName;
    private String majorField;
    private String major;
    private Year graduationYear;

    public AcademicInfoRequest() {
    }

    public AcademicInfoRequest(String highestEdu, String schoolName, String majorField, String major, Year graduationYear) {
        this.highestEdu = highestEdu;
        this.schoolName = schoolName;
        this.majorField = majorField;
        this.major = major;
        this.graduationYear = graduationYear;
    }

    public AcademicInfo toAcademicInfo(Member member, Resume resume) {
        return AcademicInfo.builder()
                .member(member)
                .resume(resume)
                .highestEdu(highestEdu)
                .schoolName(schoolName)
                .majorField(majorField)
                .major(major)
                .graduationYear(graduationYear)
                .build();
    }
}

