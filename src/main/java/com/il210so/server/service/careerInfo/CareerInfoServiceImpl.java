package com.il210so.server.service.careerInfo;

import com.il210so.server.dto.request.careerInfo.CareerInfoRequest;
import com.il210so.server.dto.response.careerInfo.CareerInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CareerInfoServiceImpl implements CareerInfoService {

    @Override
    public void save(CareerInfoRequest careerInfoRequest, Long memberId, Long resumeId) {

    }

    @Override
    public void edit(CareerInfoRequest careerInfoRequest, Long memberId, Long resumeId, Long careerInfoId) {

    }

    @Override
    public CareerInfoResponse showCareerInfos(Long memberId, Long resumeId) {
        return null;
    }
}
