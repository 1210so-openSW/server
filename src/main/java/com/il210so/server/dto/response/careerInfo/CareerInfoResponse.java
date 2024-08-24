package com.il210so.server.dto.response.careerInfo;

import com.il210so.server.domain.CareerInfo;
import lombok.Getter;

import java.time.YearMonth;

@Getter
public class CareerInfoResponse {
    private String place;
    private YearMonth startDate;
    private YearMonth endDate;
    private String task;

    public CareerInfoResponse(String place, YearMonth startDate, YearMonth endDate, String task) {
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;
        this.task = task;
    }

    private static CareerInfoResponse from(CareerInfo careerInfo) {
        return new CareerInfoResponse(
                careerInfo.getPlace(),
                careerInfo.getStartDate(),
                careerInfo.getEndDate(),
                careerInfo.getTask());
    }
}
