package com.il210so.server.service.academicInfo;

import com.il210so.server.dto.response.academicInfo.AcademicInfoResponse;

public interface AcademicInfoService {
    void saveAcademicInfos(Long memberId, Long resumeId);

    void editAcademicInfos(Long memberId, Long resumeId);

    AcademicInfoResponse showAcademicInfos(Long memberId, Long resumeId);


}
