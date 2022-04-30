package com.example.demo.error.exception;

import com.example.demo.error.ErrorCode;

/**
 * 예외 처리 커스터마이징
 *
 * @author hyeon
 * @since 2022-04-30
 */
public class CustomException extends RuntimeException {

    private ErrorCode errorCode;
  
    public CustomException(ErrorCode errorCode, String message) {
      super(message);
      this.errorCode = errorCode;
    }
  
    public CustomException(ErrorCode errorCode) {
      super(errorCode.getMessage());
      this.errorCode = errorCode;
    }
  
    public ErrorCode getErrorCode() {
      return this.errorCode;
    }
  }