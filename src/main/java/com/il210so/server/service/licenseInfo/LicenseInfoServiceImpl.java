package com.il210so.server.service.licenseInfo;

import com.il210so.server.domain.LicenseInfo;
import com.il210so.server.domain.Member;
import com.il210so.server.domain.Resume;
import com.il210so.server.dto.request.licenseInfo.LicenseInfoRequest;
import com.il210so.server.dto.response.licenseInfo.LicenseInfoResponse;
import com.il210so.server.exception.ErrorCode;
import com.il210so.server.exception.Il210soException;
import com.il210so.server.repository.LicenseInfoRepository;
import com.il210so.server.repository.MemberRepository;
import com.il210so.server.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LicenseInfoServiceImpl implements LicenseInfoService {

    private final MemberRepository memberRepository;
    private final ResumeRepository resumeRepository;
    private final LicenseInfoRepository licenseInfoRepository;

    @Override
    public void save(LicenseInfoRequest licenseInfoRequest, Long memberId, Long resumeId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        LicenseInfo licenseInfo = licenseInfoRequest.toLicenseInfo(findMemberById(memberId), findResumeById(resumeId));
        licenseInfoRepository.save(licenseInfo);
    }

    @Override
    public void edit(LicenseInfoRequest licenseInfoRequest, Long memberId, Long resumeId, Long licenseInfoId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        LicenseInfo licenseInfo = findByLicenseInfoId(licenseInfoId);
        LicenseInfo updatedLicenseInfo = licenseInfo.update(
                licenseInfoRequest.getLicenseName(),
                licenseInfoRequest.getGetDate(),
                licenseInfoRequest.getAgency());
        licenseInfoRepository.save(updatedLicenseInfo);
    }

    @Override
    public List<LicenseInfoResponse> showLicenseInfos(Long memberId, Long resumeId) {
        validateMemberExists(memberId);
        validateResumeExists(resumeId);
        List<LicenseInfo> licenseInfos = licenseInfoRepository.findByMemberIdAndResumeId(memberId, resumeId);
        return LicenseInfoResponse.from(licenseInfos);
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

    private LicenseInfo findByLicenseInfoId(Long licenseInfoId) {
        return licenseInfoRepository.findById(licenseInfoId)
                .orElseThrow(() -> new Il210soException(ErrorCode.LICENSE_INFO_NOT_FOUND));
    }
}
