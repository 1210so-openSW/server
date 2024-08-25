package com.il210so.server.service.personalInfo;

import com.il210so.server.dto.request.personalInfo.PersonalInfoRequest;
import com.il210so.server.dto.response.personalInfo.PersonalInfoResponse;

public interface PersonalInfoService {

    void savePersonalInfo(PersonalInfoRequest personalInfoRequest, Long memberId, Long resumeId);

    void editPersonalInfo(PersonalInfoRequest personalInfoRequest, Long memberId, Long resumeId);

    PersonalInfoResponse showPersonalInfos(Long memberId, Long resumeId);
}
