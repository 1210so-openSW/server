package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Resume {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Resume() {
    }

    @Builder
    public Resume(Long id, Member member) {
        this.id = id;
        this.member = member;
    }
}
