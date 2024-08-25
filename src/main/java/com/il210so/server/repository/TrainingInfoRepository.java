package com.il210so.server.repository;

import com.il210so.server.domain.TrainingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingInfoRepository extends JpaRepository<TrainingInfo, Long> {
    List<TrainingInfo> findByMemberIdAndResumeId(Long memberId, Long resumeId);

    TrainingInfo findByIdAndMemberIdAndResumeId(Long trainingInfoId, Long memberId, Long resumeId);
}
