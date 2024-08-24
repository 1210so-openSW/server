package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class TrainingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(name = "training_name", nullable = false)
    private String trainingName;

    @Column(name = "training_start_date", nullable = false)
    private String trainingStartDate;

    @Column(name = "training_end_date", nullable = false)
    private String trainingEndDate;

    @Column(name = "training_agency", nullable = false)
    private String trainingAgency;

    public TrainingInfo() {
    }

    @Builder
    public TrainingInfo(Long trainingId, Member member, Resume resume, String trainingName, String trainingStartDate, String trainingEndDate, String trainingAgency) {
        this.trainingId = trainingId;
        this.member = member;
        this.resume = resume;
        this.trainingName = trainingName;
        this.trainingStartDate = trainingStartDate;
        this.trainingEndDate = trainingEndDate;
        this.trainingAgency = trainingAgency;
    }
}
