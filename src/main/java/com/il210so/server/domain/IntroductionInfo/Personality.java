package com.il210so.server.domain.IntroductionInfo;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Personality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "introduction_id", nullable = false)
    private IntroductionInfo introductionInfo;

    @Column(name = "personality", nullable = false)
    private String personality;

    public Personality() {
    }

    @Builder
    public Personality(Long id, IntroductionInfo introductionInfo, String personality) {
        this.id = id;
        this.introductionInfo = introductionInfo;
        this.personality = personality;
    }
}
