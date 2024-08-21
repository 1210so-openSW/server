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

    @Column(name = "major")
    private String major;

    @Column(name = "detailedMajor")
    private String detailedMajor;

    @Column(name = "graduationDate")
    private String graduationDate;

    protected AcademicInfo() {
    }

    @Builder
    public AcademicInfo(Long id, Member member, String highestEdu, String schoolName, String major, String detailedMajor, String graduationDate) {
        this.id = id;
        this.member = member;
        this.highestEdu = highestEdu;
        this.schoolName = schoolName;
        this.major = major;
        this.detailedMajor = detailedMajor;
        this.graduationDate = graduationDate;
    }
}
