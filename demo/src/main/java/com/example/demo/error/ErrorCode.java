package com.example.demo.error;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum ErrorCode {
    BAD_REQUEST(400, "BAD_REQUEST", "Bad Request"),
    INTER_SERVER_ERROR(500, "INTER_SERVER_ERROR", "Inner Server Error");
    
    private int status;
    private String code;
    private String message;
  
    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
