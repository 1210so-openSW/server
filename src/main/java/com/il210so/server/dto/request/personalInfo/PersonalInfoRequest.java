package com.il210so.server.dto.request.personalInfo;

import com.il210so.server.domain.Member;
import com.il210so.server.domain.PersonalInfo;
import com.il210so.server.domain.Resume;

import java.time.LocalDate;

public class PersonalInfoRequest {
    private String name;
    private LocalDate bdate;
    private String address;
    private String phoneNumber;
    private String emergencyPhone;

    public PersonalInfoRequest() {
    }

    public PersonalInfoRequest(String name, LocalDate bdate, String address, String phoneNumber, String emergencyPhone) {
        this.name = name;
        this.bdate = bdate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
    }

    public PersonalInfo toPersonalInfo(Member member, Resume resume) {
        return PersonalInfo.builder()
                .member(member)
                .resume(resume)
                .name(this.name)
                .bdate(this.bdate)
                .address(this.address)
                .phoneNumber(this.phoneNumber)
                .build();
    }

}
