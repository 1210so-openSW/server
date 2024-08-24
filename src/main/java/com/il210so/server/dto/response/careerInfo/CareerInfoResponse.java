package com.il210so.server.dto.response.careerInfo;

import com.il210so.server.domain.CareerInfo;
import lombok.Getter;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CareerInfoResponse {
    private Long id;
    private String place;
    private YearMonth startDate;
    private YearMonth endDate;
    private String task;

    public CareerInfoResponse(Long id, String place, YearMonth startDate, YearMonth endDate, String task) {
        this.id = id;
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;
        this.task = task;
    }

    public static CareerInfoResponse from(CareerInfo careerInfo) {
        return new CareerInfoResponse(
                careerInfo.getId(),
                careerInfo.getPlace(),
                careerInfo.getStartDate(),
                careerInfo.getEndDate(),
                careerInfo.getTask());
    }

    public static List<CareerInfoResponse> from(List<CareerInfo> careerInfos) {
        return careerInfos.stream()
                .map(CareerInfoResponse::from)
                .collect(Collectors.toList());
    }
}
