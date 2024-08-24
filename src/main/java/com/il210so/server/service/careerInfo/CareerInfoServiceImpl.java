package com.il210so.server.service.careerInfo;

import com.il210so.server.domain.CareerInfo;
import com.il210so.server.domain.Member;
import com.il210so.server.domain.Resume;
import com.il210so.server.dto.request.careerInfo.CareerInfoRequest;
import com.il210so.server.dto.response.careerInfo.CareerInfoResponse;
import com.il210so.server.exception.ErrorCode;
import com.il210so.server.exception.Il210soException;
import com.il210so.server.repository.CareerInfoRepository;
import com.il210so.server.repository.MemberRepository;
import com.il210so.server.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CareerInfoServiceImpl implements CareerInfoService {

    private final MemberRepository memberRepository;
    private final ResumeRepository resumeRepository;
    private CareerInfoRepository careerInfoRepository;

    @Override
    public void save(CareerInfoRequest careerInfoRequest, Long memberId, Long resumeId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        CareerInfo careerInfo = careerInfoRequest.toCareerInfo(findMemberById(memberId), findResumeById(resumeId));
        careerInfoRepository.save(careerInfo);
    }

    @Override
    public void edit(CareerInfoRequest careerInfoRequest, Long memberId, Long resumeId, Long careerInfoId) {

    }

    @Override
    public CareerInfoResponse showCareerInfos(Long memberId, Long resumeId) {
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
}
