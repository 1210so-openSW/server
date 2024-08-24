package com.il210so.server.controller;

import com.il210so.server.ai.GptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeController {

    private final GptService gptService;

    public ResumeController(GptService gptService) {
        this.gptService = gptService;
    }

    @GetMapping("/generate-resume")
    public String generateResume(@RequestParam String keywords) {
        try {
            return gptService.generateResume(keywords);
        } catch (Exception e) {
            return "Failed to generate resume: " + e.getMessage();
        }
    }
}
