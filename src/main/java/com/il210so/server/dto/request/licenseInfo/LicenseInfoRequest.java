package com.il210so.server.dto.request.licenseInfo;

import com.il210so.server.domain.LicenseInfo;
import com.il210so.server.domain.Member;
import com.il210so.server.domain.Resume;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LicenseInfoRequest {
    private String licenseName;
    private LocalDate getDate;
    private String agency;

    public LicenseInfoRequest() {
    }

    public LicenseInfoRequest(String licenseName, LocalDate getDate, String agency) {
        this.licenseName = licenseName;
        this.getDate = getDate;
        this.agency = agency;
    }

    public LicenseInfo toLicenseInfo(Member member, Resume resume) {
        return new LicenseInfo().builder()
                .member(member)
                .resume(resume)
                .licenseName(this.licenseName)
                .getDate(this.getDate)
                .agency(this.agency)
                .build();
    }
}
