package com.il210so.server.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "bdate", nullable = false)
    private LocalDate bdate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "emergency_phone")
    private String emergencyPhone;

    public PersonalInfo() {
    }

    @Builder
    public PersonalInfo(Long id, Member member, Resume resume, String name, LocalDate bdate, String address, String email, String phoneNumber, String emergencyPhone) {
        this.id = id;
        this.member = member;
        this.resume = resume;
        this.name = name;
        this.bdate = bdate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.emergencyPhone = emergencyPhone;
    }

    public PersonalInfo update(String name, LocalDate bdate, String address, String email, String phoneNumber, String emergencyPhone) {
        return new PersonalInfo().builder()
                .id(this.id)
                .member(this.member)
                .resume(this.resume)
                .name(name)
                .bdate(bdate)
                .address(address)
                .email(email)
                .phoneNumber(phoneNumber)
                .emergencyPhone(emergencyPhone)
                .build();
    }
}
