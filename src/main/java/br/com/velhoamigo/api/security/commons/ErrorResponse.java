package br.com.velhoamigo.api.security.commons;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse {

    private final HttpStatus status;
    private final String message;
    private final ErrorCode errorCode;
    private final Date timeStamp;

    private ErrorResponse(HttpStatus status, String message, ErrorCode errorCode) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.timeStamp = new java.util.Date();
    }

    public static ErrorResponse of(HttpStatus status, String message, ErrorCode errorCode) {
        return new ErrorResponse(status, message, errorCode);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
