package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Year;

@Getter
@Entity
public class AcademicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(name = "highest_edu", nullable = false)
    private String highestEdu;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "major_field")
    private String majorField;

    @Column(name = "major")
    private String major;

    @Column(name = "graduation_year")
    private Year graduationYear;

    public AcademicInfo() {
    }

    @Builder
    public AcademicInfo(Long id, Member member, Resume resume, String highestEdu, String schoolName, String majorField, String major, Year graduationYear) {
        this.id = id;
        this.member = member;
        this.resume = resume;
        this.highestEdu = highestEdu;
        this.schoolName = schoolName;
        this.majorField = majorField;
        this.major = major;
        this.graduationYear = graduationYear;
    }

    public AcademicInfo update(String highestEdu, String schoolName, String majorField, String major, Year graduationYear) {
        return new AcademicInfo().builder()
                .id(this.id)
                .member(this.member)
                .resume(this.resume)
                .highestEdu(highestEdu)
                .schoolName(schoolName)
                .majorField(majorField)
                .major(major)
                .graduationYear(graduationYear)
                .build();
    }
}
