package com.il210so.server.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum ErrorCode {

    MEMBER_NOT_FOUND(NOT_FOUND, "회원을 찾을 수 없습니다."),
    RESUME_NOT_FOUND(NOT_FOUND, "이력서를 찾을 수 없습니다."),
    ACADEMIC_INFO_NOT_FOUND(NOT_FOUND, "학력정보를 찾을 수 없습니다."),
    CAREER_INFO_NOT_FOUND(NOT_FOUND, "경력정보를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
