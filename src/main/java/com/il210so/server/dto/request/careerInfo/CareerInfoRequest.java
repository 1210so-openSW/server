package com.il210so.server.dto.request.careerInfo;

import com.il210so.server.domain.CareerInfo;
import com.il210so.server.domain.Member;
import com.il210so.server.domain.Resume;

import java.time.YearMonth;

public class CareerInfoRequest {
    private String place;
    private YearMonth startDate;
    private YearMonth endDate;
    private String task;

    public CareerInfoRequest() {
    }

    public CareerInfoRequest(String place, YearMonth startDate, YearMonth endDate, String task) {
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;
        this.task = task;
    }

    public CareerInfo toCareerInfo(Member member, Resume resume) {
        return CareerInfo.builder()
                .member(member)
                .resume(resume)
                .place(this.place)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .task(this.task)
                .build();
    }
}
