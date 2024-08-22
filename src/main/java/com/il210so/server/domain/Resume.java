package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "webview_url")
    private String webviewUrl;

    @Column(name = "pdf_url")
    private String pdfUrl;

    @OneToMany(mappedBy = "resume")
    private List<LicenseInfo> licenses;

    @OneToMany(mappedBy = "resume")
    private List<CareerInfo> careers;

    @OneToMany(mappedBy = "resume")
    private List<TrainingInfo> trainings;

    public Resume() {
    }
    @Builder
    public Resume(Member member, String webviewUrl, String pdfUrl, List<LicenseInfo> licenses, List<CareerInfo> careers, List<TrainingInfo> trainings) {
        this.member = member;
        this.webviewUrl = webviewUrl;
        this.pdfUrl = pdfUrl;
        this.licenses = licenses;
        this.careers = careers;
        this.trainings = trainings;
    }
}
