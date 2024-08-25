package com.il210so.server.controller;

import com.il210so.server.dto.request.licenseInfo.LicenseInfoRequest;
import com.il210so.server.dto.response.licenseInfo.LicenseInfoResponse;
import com.il210so.server.service.licenseInfo.LicenseInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members/{memberId}/resumes/{resumeId}/license-infos")
public class LicenseInfoController {

    private final LicenseInfoService licenseInfoService;

    @PostMapping
    public ResponseEntity<Void> save(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId,
            @RequestBody LicenseInfoRequest licenseInfoRequest) {
        licenseInfoService.save(licenseInfoRequest, memberId, resumeId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{licenseInfoId}")
    public ResponseEntity<Void> edit(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId,
            @PathVariable("licenseInfoId") Long licenseInfoId,
            @RequestBody LicenseInfoRequest licenseInfoRequest) {
        licenseInfoService.edit(licenseInfoRequest, memberId, resumeId, licenseInfoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<LicenseInfoResponse> getLicenseInfos(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId) {
        return licenseInfoService.showLicenseInfos(memberId, resumeId);
    }
}
