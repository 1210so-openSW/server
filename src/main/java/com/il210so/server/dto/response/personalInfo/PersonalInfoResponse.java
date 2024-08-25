package com.il210so.server.dto.response.personalInfo;

import com.il210so.server.domain.PersonalInfo;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PersonalInfoResponse {
    private String name;
    private LocalDate bdate;
    private String address;
    private String email;
    private String phoneNumber;
    private String emergencyPhone;

    public PersonalInfoResponse(String name, LocalDate bdate, String address, String email, String phoneNumber, String emergencyPhone) {
        this.name = name;
        this.bdate = bdate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
    }

    public static PersonalInfoResponse from(PersonalInfo personalInfo) {
        return new PersonalInfoResponse(
                personalInfo.getName(),
                personalInfo.getBdate(),
                personalInfo.getAddress(),
                personalInfo.getEmail(),
                personalInfo.getPhoneNumber(),
                personalInfo.getEmergencyPhone());
    }
}
