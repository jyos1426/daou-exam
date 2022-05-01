package com.example.demo.enums;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 에러 코드 Enum 정의
 *
 * @author hyeon
 * @since 2022-05-01
 */
@RequiredArgsConstructor
@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum OrgType {
    COMPANY("Company"),
    DIVISION("Division"),
    TEAM("Team"),
    MEMBER("Member");
    
    private String code;
  
    OrgType( String code) {
        this.code = code;
    }
}
