package com.il210so.server.service.trainingInfo;

import com.il210so.server.domain.LicenseInfo;
import com.il210so.server.domain.Member;
import com.il210so.server.domain.Resume;
import com.il210so.server.domain.TrainingInfo;
import com.il210so.server.dto.request.trainingInfo.TrainingInfoRequest;
import com.il210so.server.dto.response.trainingInfo.TrainingInfoResponse;
import com.il210so.server.exception.ErrorCode;
import com.il210so.server.exception.Il210soException;
import com.il210so.server.repository.LicenseInfoRepository;
import com.il210so.server.repository.MemberRepository;
import com.il210so.server.repository.ResumeRepository;
import com.il210so.server.repository.TrainingInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TrainingInfoServiceImpl implements TrainingInfoService {

    private final MemberRepository memberRepository;
    private final ResumeRepository resumeRepository;
    private final TrainingInfoRepository trainingInfoRepository;

    @Override
    public void save(TrainingInfoRequest trainingInfoRequest, Long memberId, Long resumeId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        TrainingInfo trainingInfo = trainingInfoRequest.toTrainingInfo(findMemberById(memberId), findResumeById(resumeId));
        trainingInfoRepository.save(trainingInfo);
    }

    @Override
    public void edit(TrainingInfoRequest trainingInfoRequest, Long memberId, Long resumeId, Long trainingInfoId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        TrainingInfo trainingInfo = findByTrainingInfoId(trainingInfoId);
        TrainingInfo updatedTrainingInfo = trainingInfo.update(
                trainingInfoRequest.getTrainingName(),
                trainingInfoRequest.getTrainingStartDate(),
                trainingInfoRequest.getTrainingEndDate(),
                trainingInfoRequest.getTrainingAgency());
        trainingInfoRepository.save(updatedTrainingInfo);
    }

    @Override
    public List<TrainingInfoResponse> showTrainingInfos(Long memberId, Long resumeId) {
        return null;
    }

    private void validateResumeExists(Long resumeId) {
        if (!resumeRepository.existsById(resumeId)) {
            throw new Il210soException(ErrorCode.RESUME_NOT_FOUND);
        }
    }

    private void validateMemberExists(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new Il210soException(ErrorCode.MEMBER_NOT_FOUND);
        }
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new Il210soException(ErrorCode.MEMBER_NOT_FOUND));
    }

    private Resume findResumeById(Long resumeId) {
        return resumeRepository.findById(resumeId)
                .orElseThrow(() -> new Il210soException(ErrorCode.RESUME_NOT_FOUND));
    }

    private TrainingInfo findByTrainingInfoId(Long trainingInfoId) {
        return trainingInfoRepository.findById(trainingInfoId)
                .orElseThrow(() -> new Il210soException(ErrorCode.TRAINING_INFO_NOT_FOUND));
    }
}
