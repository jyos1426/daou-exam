package com.example.demo.error;

import java.util.NoSuchElementException;
import com.example.demo.error.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 에러 처리 Handler
 *
 * @author hyeon
 * @since 2022-04-30
 */
@RestControllerAdvice
@RestController
public class ErrorControllerAdvice {

  /**
   * 500 Internal Error Handler
   * 
   * @param e
   * @return
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  protected ResponseEntity<ErrorResponse> handleException(CustomException e) {
    ErrorResponse response = ErrorResponse.of(ErrorCode.INTER_SERVER_ERROR);
    response.setMessage(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  /**
   * 400 Bad Request Handler
   * 
   * @param e
   * @return
   */
  @ExceptionHandler(value = NoSuchElementException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected ResponseEntity<ErrorResponse> handleNoSuchElementException(CustomException e) {
    
    ErrorResponse response = ErrorResponse.of(ErrorCode.BAD_REQUEST);
    response.setMessage(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
  
  /**
   * 500 Custom Error Handler
   * 
   * @param e
   * @return
   */
  @ExceptionHandler(value = CustomException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    ErrorResponse response = ErrorResponse.of(e.getErrorCode());
    response.setMessage(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}