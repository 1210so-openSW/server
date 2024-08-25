package com.il210so.server.dto.response.trainingInfo;

import com.il210so.server.domain.TrainingInfo;
import lombok.Getter;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TrainingInfoResponse {
    private Long id;
    private String trainingName;
    private YearMonth trainingStartDate;
    private YearMonth trainingEndDate;
    private String trainingAgency;

    public TrainingInfoResponse(Long id, String trainingName, YearMonth trainingStartDate, YearMonth trainingEndDate, String trainingAgency) {
        this.id = id;
        this.trainingName = trainingName;
        this.trainingStartDate = trainingStartDate;
        this.trainingEndDate = trainingEndDate;
        this.trainingAgency = trainingAgency;
    }

    public static TrainingInfoResponse from(TrainingInfo trainingInfo) {
        return new TrainingInfoResponse(
                trainingInfo.getId(),
                trainingInfo.getTrainingName(),
                trainingInfo.getTrainingStartDate(),
                trainingInfo.getTrainingEndDate(),
                trainingInfo.getTrainingAgency());
    }

    public static List<TrainingInfoResponse> from (List<TrainingInfo> trainingInfos) {
        return trainingInfos.stream()
                .map(TrainingInfoResponse::from)
                .collect(Collectors.toList());
    }
}
