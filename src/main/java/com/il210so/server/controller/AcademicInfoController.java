package com.il210so.server.controller;

import com.il210so.server.dto.request.acdemicInfo.AcademicInfoRequest;
import com.il210so.server.dto.response.academicInfo.AcademicInfoResponse;
import com.il210so.server.service.academicInfo.AcademicInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members/{memberId}/resumes/{resumeId}/academic-infos")
public class AcademicInfoController {

    private final AcademicInfoService academicInfoService;

    @PostMapping
    public ResponseEntity<Void> save(
            @PathVariable Long memberId,
            @PathVariable Long resumeId,
            @RequestBody AcademicInfoRequest academicInfoRequest) {
        academicInfoService.saveAcademicInfos(academicInfoRequest, memberId, resumeId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> edit(
            @PathVariable Long memberId,
            @PathVariable Long resumeId,
            @RequestBody AcademicInfoRequest academicInfoRequest) {
        academicInfoService.editAcademicInfos(academicInfoRequest, memberId, resumeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public AcademicInfoResponse getAcademicInfos(
            @PathVariable Long memberId,
            @PathVariable Long resumeId) {
        return academicInfoService.showAcademicInfos(memberId, resumeId);
    }
}
