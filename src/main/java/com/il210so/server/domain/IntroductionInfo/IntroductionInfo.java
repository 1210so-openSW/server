package com.il210so.server.domain.IntroductionInfo;

import com.il210so.server.domain.Member;
import com.il210so.server.domain.Resume;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class IntroductionInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @OneToMany(mappedBy = "introductionInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Personality> personalities;

    @Column(name = "cover_letter", nullable = false)
    private String coverLetter;

    public IntroductionInfo() {
    }

    @Builder
    public IntroductionInfo(Long id, Member member, Resume resume, List<Personality> personalities, String coverLetter) {
        this.id = id;
        this.member = member;
        this.resume = resume;
        this.personalities = personalities;
        this.coverLetter = coverLetter;
    }
}
