package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "webview_url")
    private String webviewUrl;

    @Column(name = "pdf_url")
    private String pdfUrl;

    public Resume() {
    }
    @Builder
    public Resume(Long id, Member member, String webviewUrl, String pdfUrl) {
        this.id = id;
        this.member = member;
        this.webviewUrl = webviewUrl;
        this.pdfUrl = pdfUrl;
    }
}