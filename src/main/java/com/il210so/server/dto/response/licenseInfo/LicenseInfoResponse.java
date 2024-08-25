package com.il210so.server.dto.response.licenseInfo;

import com.il210so.server.domain.CareerInfo;
import com.il210so.server.domain.LicenseInfo;
import com.il210so.server.dto.response.careerInfo.CareerInfoResponse;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<LicenseInfoResponse> from(List<LicenseInfo> licenseInfos) {
        return licenseInfos.stream()
                .map(LicenseInfoResponse::from)
                .collect(Collectors.toList());
    }
}


