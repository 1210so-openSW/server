package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class CareerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "task", nullable = false)
    private String task;

    public CareerInfo() {
    }

    @Builder
    public CareerInfo(Long id, Member member, Resume resume, String place, Date startDate, Date endDate, String task) {
        this.id = id;
        this.member = member;
        this.resume = resume;
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;
        this.task = task;
    }
}
