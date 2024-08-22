package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class LicenseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(name = "license_name", nullable = false)
    private String licenseName;

    @Column(name = "get_date", nullable = false)
    private String getDate;

    @Column(name = "agency", nullable = false)
    private String agency;
    public LicenseInfo() {
    }

    @Builder
    public LicenseInfo(Long licenseId, Member member, Resume resume, String licenseName, String getDate, String agency) {
        this.licenseId = licenseId;
        this.member = member;
        this.resume = resume;
        this.licenseName = licenseName;
        this.getDate = getDate;
        this.agency = agency;
    }
}
