package com.il210so.server.service.licenseInfo;

import com.il210so.server.dto.request.licenseInfo.LicenseInfoRequest;
import com.il210so.server.dto.response.licenseInfo.LicenseInfoResponse;

import java.util.List;

public interface LicenseInfoService {
    void save(LicenseInfoRequest licenseInfoRequest, Long memberId, Long resumeId);

    void edit(LicenseInfoRequest licenseInfoRequest, Long memberId, Long resumeId, Long licenseInfoId);

    List<LicenseInfoResponse> showLicenseInfos(Long memberId, Long resumeId);
}
