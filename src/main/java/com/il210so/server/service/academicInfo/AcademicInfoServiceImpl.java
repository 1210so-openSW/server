package com.il210so.server.service.academicInfo;

import com.il210so.server.domain.AcademicInfo;
import com.il210so.server.domain.Member;
import com.il210so.server.domain.Resume;
import com.il210so.server.dto.request.acdemicInfo.AcademicInfoRequest;
import com.il210so.server.dto.response.academicInfo.AcademicInfoResponse;
import com.il210so.server.exception.ErrorCode;
import com.il210so.server.exception.Il210soException;
import com.il210so.server.repository.AcademicInfoRepository;
import com.il210so.server.repository.MemberRepository;
import com.il210so.server.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AcademicInfoServiceImpl implements AcademicInfoService {

    private final MemberRepository memberRepository;
    private final ResumeRepository resumeRepository;
    private final AcademicInfoRepository academicInfoRepository;

    @Override
    public void saveAcademicInfos(AcademicInfoRequest academicInfoRequest, Long memberId, Long resumeId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        AcademicInfo academicInfo = academicInfoRequest.toAcademicInfo(findMemberById(memberId), findResumeById(resumeId));
        academicInfoRepository.save(academicInfo);
    }

    private void validateResumeExists(Long resumeId) {
        if(!resumeRepository.existsById(resumeId)) {
            throw new Il210soException(ErrorCode.RESUME_NOT_FOUND);
        }
    }

    private void validateMemberExists(Long memberId) {
        if(!memberRepository.existsById(memberId)) {
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

    @Override
    public void editAcademicInfos(AcademicInfoRequest academicInfoRequest, Long memberId, Long resumeId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        validateAcademicInfoExists(memberId, resumeId);
        AcademicInfo academicInfo = academicInfoRepository.findByMemberIdAndResumeId(memberId, resumeId);
        AcademicInfo updatedAcademicInfo = academicInfo.update(
                academicInfoRequest.getHighestEdu(),
                academicInfoRequest.getSchoolName(),
                academicInfoRequest.getMajorField(),
                academicInfoRequest.getMajor(),
                academicInfoRequest.getGraduationYear());
        academicInfoRepository.save(updatedAcademicInfo);
    }

    private void validateAcademicInfoExists(Long memberId, Long resumeId) {
        if (!(academicInfoRepository.existsByMemberIdAndResumeId(memberId, resumeId))) {
            throw new Il210soException(ErrorCode.ACADEMIC_INFO_NOT_FOUND);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public AcademicInfoResponse showAcademicInfos(Long memberId, Long resumeId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        validateAcademicInfoExists(memberId, resumeId);
        AcademicInfo academicInfo = academicInfoRepository.findByMemberIdAndResumeId(memberId, resumeId);
        return AcademicInfoResponse.from(academicInfo);
    }
}