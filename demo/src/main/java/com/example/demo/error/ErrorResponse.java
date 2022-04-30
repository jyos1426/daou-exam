package com.example.demo.error;

import lombok.Getter;
import lombok.Setter;

/**
 * 에러 응답 Enum 정의
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Getter
@Setter
public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(ErrorCode code, String message){
        this.code = code.getCode();
        this.message = message;
    }

    public ErrorResponse(ErrorCode code) {
        this.message = code.getMessage();
        this.code = code.getCode();
    }

    public static ErrorResponse of(ErrorCode code) {
      return new ErrorResponse(code);
    }
}