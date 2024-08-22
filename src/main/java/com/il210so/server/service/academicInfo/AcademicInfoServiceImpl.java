package com.il210so.server.service.academicInfo;

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
    @Override
    public void saveAcademicInfos(AcademicInfoRequest academicInfoRequest, Long memberId, Long resumeId) {
    }


    @Override
    public void editAcademicInfos(AcademicInfoRequest academicInfoRequest, Long memberId, Long resumeId) {

    }

    @Override
    @Transactional(readOnly = true)
    public AcademicInfoResponse showAcademicInfos(Long memberId, Long resumeId) {
        return null;
    }


}
