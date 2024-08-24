package com.il210so.server.repository;

import com.il210so.server.domain.CareerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CareerInfoRepository extends JpaRepository<CareerInfo, Long> {
    boolean existsByMemberIdAndResumeId(Long memberId, Long resumeId);
    List<CareerInfo> findByMemberIdAndResumeId(Long memberId, Long resumeId);
    CareerInfo findByIdAndMemberIdAndResumeId(Long id, Long memberId, Long resumeId);
}
