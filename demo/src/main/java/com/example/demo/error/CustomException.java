package com.example.demo.error;

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