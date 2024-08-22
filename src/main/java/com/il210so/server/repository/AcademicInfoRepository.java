package com.il210so.server.repository;

import com.il210so.server.domain.AcademicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicInfoRepository extends JpaRepository<AcademicInfo, Long> {
    boolean existsByMemberIdAndResumeId(Long memberId, Long resumeId);
    AcademicInfo findByMEmberIdAndResumeId(Long memberId, Long resumeId);

}
