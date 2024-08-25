package com.il210so.server.service.trainingInfo;

import com.il210so.server.dto.request.trainingInfo.TrainingInfoRequest;
import com.il210so.server.dto.response.trainingInfo.TrainingInfoResponse;

import java.util.List;

public interface TrainingInfoService {
    void save(TrainingInfoRequest trainingInfoRequest, Long memberId, Long resumeId);

    void edit(TrainingInfoRequest trainingInfoRequest, Long memberId, Long resumeId, Long trainingInfoId);

    List<TrainingInfoResponse> showTrainingInfos(Long memberId, Long resumeId);
}
