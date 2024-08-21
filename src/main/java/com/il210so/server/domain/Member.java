package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="pwd", nullable = false)
    private String pwd;

    protected Member() {}

    @Builder
    public Member(Long id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
}
