package com.il210so.server.domain;

import com.il210so.server.dto.response.licenseInfo.LicenseInfoResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class LicenseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(name = "license_name", nullable = false)
    private String licenseName;

    @Column(name = "get_date", nullable = false)
    private LocalDate getDate;

    @Column(name = "agency", nullable = false)
    private String agency;

    public LicenseInfo() {
    }

    @Builder
    public LicenseInfo(Long id, Member member, Resume resume, String licenseName, LocalDate getDate, String agency) {
        this.id = id;
        this.member = member;
        this.resume = resume;
        this.licenseName = licenseName;
        this.getDate = getDate;
        this.agency = agency;
    }

    public LicenseInfo update(String licenseName, LocalDate getDate, String agency) {
        return new LicenseInfo().builder()
                .id(this.id)
                .member(this.member)
                .resume(this.resume)
                .licenseName(licenseName)
                .getDate(getDate)
                .agency(agency)
                .build();
    }
}
