package com.il210so.server.dto.response.licenseInfo;

import com.il210so.server.domain.LicenseInfo;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LicenseInfoResponse {
    private Long id;
    private String licenseName;
    private LocalDate getDate;
    private String agency;

    public LicenseInfoResponse(Long id, String licenseName, LocalDate getDate, String agency) {
        this.id = id;
        this.licenseName = licenseName;
        this.getDate = getDate;
        this.agency = agency;
    }

    public static LicenseInfoResponse from (LicenseInfo licenseInfo) {
        return new LicenseInfoResponse(
                licenseInfo.getId(),
                licenseInfo.getLicenseName(),
                licenseInfo.getGetDate(),
                licenseInfo.getAgency()
        );
    }
}


