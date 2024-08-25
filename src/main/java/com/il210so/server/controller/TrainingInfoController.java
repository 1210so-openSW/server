package com.il210so.server.controller;

import com.il210so.server.dto.request.trainingInfo.TrainingInfoRequest;
import com.il210so.server.dto.response.trainingInfo.TrainingInfoResponse;
import com.il210so.server.service.trainingInfo.TrainingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members/{memberId}/resumes/{resumeId}/training-infos")
public class TrainingInfoController {

    private final TrainingInfoService trainingInfoService;

    @PostMapping
    public ResponseEntity<Void> save(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId,
            @RequestBody TrainingInfoRequest trainingInfoRequest) {
        trainingInfoService.save(trainingInfoRequest, memberId, resumeId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{trainingInfoId}")
    public ResponseEntity<Void> edit(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId,
            @PathVariable("trainingInfoId") Long trainingInfoId,
            @RequestBody TrainingInfoRequest trainingInfoRequest) {
        trainingInfoService.edit(trainingInfoRequest, memberId, resumeId, trainingInfoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<TrainingInfoResponse> getTrainingInfos(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId) {
        return trainingInfoService.showTrainingInfos(memberId, resumeId);
    }
}