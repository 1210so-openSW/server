package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class AcademicInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "resume_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Resume resume;

    @JoinColumn(name = "member_Id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(name = "highestEdu", nullable = false)
    private String highestEdu;

    @Column(name = "schoolName", nullable = false)
    private String schoolName;

    @Column(name = "majorField")
    private String majorField;

    @Column(name = "major")
    private String major;

    @Column(name = "graduationDate")
    private String graduationDate;

    protected AcademicInfo() {
    }

    @Builder
    public AcademicInfo(Long id, Resume resume, Member member, String highestEdu, String schoolName, String majorField, String major, String graduationDate) {
        this.id = id;
        this.resume = resume;
        this.member = member;
        this.highestEdu = highestEdu;
        this.schoolName = schoolName;
        this.majorField = majorField;
        this.major = major;
        this.graduationDate = graduationDate;
    }
}
