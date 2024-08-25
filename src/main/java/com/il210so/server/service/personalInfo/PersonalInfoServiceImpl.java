package com.il210so.server.service.personalInfo;

import com.il210so.server.domain.AcademicInfo;
import com.il210so.server.domain.Member;
import com.il210so.server.domain.PersonalInfo;
import com.il210so.server.domain.Resume;
import com.il210so.server.dto.request.personalInfo.PersonalInfoRequest;
import com.il210so.server.dto.response.personalInfo.PersonalInfoResponse;
import com.il210so.server.exception.ErrorCode;
import com.il210so.server.exception.Il210soException;
import com.il210so.server.repository.MemberRepository;
import com.il210so.server.repository.PersonalInfoRepository;
import com.il210so.server.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonalInfoServiceImpl implements PersonalInfoService{

    private final MemberRepository memberRepository;
    private final ResumeRepository resumeRepository;
    private final PersonalInfoRepository personalInfoRepository;

    @Override
    public void savePersonalInfo(PersonalInfoRequest personalInfoRequest, Long memberId, Long resumeId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        PersonalInfo personalInfo = personalInfoRequest.toPersonalInfo(findMemberById(memberId), findResumeById(resumeId));
        personalInfoRepository.save(personalInfo);
    }

    @Override
    public void editPersonalInfo(PersonalInfoRequest personalInfoRequest, Long memberId, Long resumeId) {

    }

    @Override
    public PersonalInfoResponse showPersonalInfos(Long memberId, Long resumeId) {
        return null;
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
}
