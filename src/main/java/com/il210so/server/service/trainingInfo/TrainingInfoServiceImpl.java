package com.il210so.server.service.trainingInfo;

import com.il210so.server.domain.TrainingInfo;
import com.il210so.server.dto.request.trainingInfo.TrainingInfoRequest;
import com.il210so.server.dto.response.trainingInfo.TrainingInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TrainingInfoServiceImpl implements TrainingInfoService {
    @Override
    public void save(TrainingInfoRequest trainingInfoRequest, Long memberId, Long resumeId) {

    }

    @Override
    public void edit(TrainingInfoRequest trainingInfoRequest, Long memberId, Long resumeId, Long trainingInfoId) {

    }

    @Override
    public List<TrainingInfoResponse> showTrainingInfos(Long memberId, Long resumeId) {
        return null;
    }
}
