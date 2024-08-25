package com.il210so.server.repository;

import com.il210so.server.domain.PersonalInfo;

public interface PersonalInfoRepository {
    boolean existsByMemberIdAndResumeId(Long memberId, Long resumeId);

    PersonalInfo findByMemberIdAndResumeId(Long memberId, Long resumeId);

}
