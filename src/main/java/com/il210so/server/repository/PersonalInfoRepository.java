package com.il210so.server.repository;

import com.il210so.server.domain.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
    boolean existsByMemberIdAndResumeId(Long memberId, Long resumeId);

    PersonalInfo findByMemberIdAndResumeId(Long memberId, Long resumeId);

}
