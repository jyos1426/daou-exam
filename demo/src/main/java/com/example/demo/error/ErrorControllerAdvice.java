package com.example.demo.error;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RestController
public class ErrorControllerAdvice {

  /**
   * 
   * @param e
   * @return 500 Internal Error
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  protected ResponseEntity<ErrorResponse> handleException(CustomException e) {
    ErrorResponse response = ErrorResponse.of(ErrorCode.INTER_SERVER_ERROR);
    response.setMessage(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  /**
   * 
   * @param e
   * @return 400 Bad Request
   */
  @ExceptionHandler(value = NoSuchElementException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected ResponseEntity<ErrorResponse> handleNoSuchElementException(CustomException e) {
    
    ErrorResponse response = ErrorResponse.of(ErrorCode.BAD_REQUEST);
    response.setMessage(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
  
  /**
   * 
   * @param e
   * @return 500 Custom Error
   */
  @ExceptionHandler(value = CustomException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    ErrorResponse response = ErrorResponse.of(e.getErrorCode());
    response.setMessage(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}