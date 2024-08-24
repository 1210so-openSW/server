package com.il210so.server.repository;

import com.il210so.server.domain.LicenseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenseInfoRepository extends JpaRepository<LicenseInfo, Long> {
    List<LicenseInfo> findByMemberIdAndResumeId(Long memberId, Long resumeId);
    LicenseInfo findByIdAndMemberIdAndResumeId(Long id, Long memberId, Long resumeId);
}
