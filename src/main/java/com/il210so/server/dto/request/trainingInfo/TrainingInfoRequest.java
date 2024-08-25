package com.il210so.server.dto.request.trainingInfo;

import com.il210so.server.domain.Member;
import com.il210so.server.domain.Resume;
import com.il210so.server.domain.TrainingInfo;

import java.time.YearMonth;

public class TrainingInfoRequest {
    private String trainingName;
    private YearMonth trainingStartDate;
    private YearMonth trainingEndDate;
    private String trainingAgency;

    public TrainingInfoRequest() {
    }

    public TrainingInfoRequest(String trainingName, YearMonth trainingStartDate, YearMonth trainingEndDate, String trainingAgency) {
        this.trainingName = trainingName;
        this.trainingStartDate = trainingStartDate;
        this.trainingEndDate = trainingEndDate;
        this.trainingAgency = trainingAgency;
    }

    public TrainingInfo toTrainingInfo(Member member, Resume resume) {
        return new TrainingInfo().builder()
                .member(member)
                .resume(resume)
                .trainingName(this.trainingName)
                .trainingStartDate(this.trainingStartDate)
                .trainingEndDate(this.trainingEndDate)
                .trainingAgency(this.trainingAgency)
                .build();
    }
}
