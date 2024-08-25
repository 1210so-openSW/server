package com.il210so.server.controller;

import com.il210so.server.dto.request.personalInfo.PersonalInfoRequest;
import com.il210so.server.dto.response.personalInfo.PersonalInfoResponse;
import com.il210so.server.service.personalInfo.PersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members/{memberId}/resumes/{resumeId}/personal-infos")
public class PersonalInfoController {

    private final PersonalInfoService personalInfoService;

    @PostMapping
    public ResponseEntity<Void> save(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId,
            @RequestBody PersonalInfoRequest personalInfoRequest) {
        personalInfoService.savePersonalInfo(personalInfoRequest, memberId, resumeId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> edit(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId,
            @RequestBody PersonalInfoRequest personalInfoRequest) {
        personalInfoService.editPersonalInfo(personalInfoRequest, memberId, resumeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public PersonalInfoResponse getPersonalInfos(
            @PathVariable("memberId") Long memberId,
            @PathVariable("resumeId") Long resumeId) {
        return personalInfoService.showPersonalInfos(memberId, resumeId);
    }
}
