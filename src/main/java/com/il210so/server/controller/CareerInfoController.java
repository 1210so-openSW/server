package com.il210so.server.controller;

import com.il210so.server.dto.request.careerInfo.CareerInfoRequest;
import com.il210so.server.dto.response.careerInfo.CareerInfoResponse;
import com.il210so.server.service.careerInfo.CareerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members/{memberId}/resumes/{resumeId}/career-infos")
public class CareerInfoController {

    private final CareerInfoService careerInfoService;

    @PostMapping
    public ResponseEntity<Void> save(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId,
            @RequestBody CareerInfoRequest careerInfoRequest) {
        careerInfoService.save(careerInfoRequest, memberId, resumeId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{careerInfoId}")
    public ResponseEntity<Void> edit(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId,
            @PathVariable("careerInfoId") Long careerInfoId,
            @RequestBody CareerInfoRequest careerInfoRequest) {
        careerInfoService.edit(careerInfoRequest, memberId, resumeId, careerInfoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<CareerInfoResponse> getCareerInfos(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId) {
        return careerInfoService.showCareerInfos(memberId, resumeId);
    }
}
