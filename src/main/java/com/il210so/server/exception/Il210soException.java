package com.il210so.server.exception;

public class Il210soException extends RuntimeException {

    private final ErrorCode errorCode;

    public Il210soException(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
