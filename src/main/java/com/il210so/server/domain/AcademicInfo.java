package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class AcademicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicId;

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

    @Column(name = "major", nullable = false)
    private String major;

    @Column(name = "detailed_major")
    private String detailedMajor;

    @Column(name = "graduation_date")
    private Date graduationDate;

    public AcademicInfo() {
    }

    @Builder
    public AcademicInfo(Long academicId, Member member, Resume resume, String highestEdu, String schoolName, String major, String detailedMajor, Date graduationDate) {
        this.academicId = academicId;
        this.member = member;
        this.resume = resume;
        this.highestEdu = highestEdu;
        this.schoolName = schoolName;
        this.major = major;
        this.detailedMajor = detailedMajor;
        this.graduationDate = graduationDate;
    }
}
