package com.il210so.server.service.careerInfo;

import com.il210so.server.dto.request.careerInfo.CareerInfoRequest;
import com.il210so.server.dto.response.careerInfo.CareerInfoResponse;

public interface CareerInfoService {

    void save(CareerInfoRequest careerInfoRequest, Long memberId, Long resumeId);

    void edit(CareerInfoRequest careerInfoRequest, Long memberId, Long resumeId, Long careerInfoId);

    CareerInfoResponse showCareerInfos(Long memberId, Long resumeId);
}
