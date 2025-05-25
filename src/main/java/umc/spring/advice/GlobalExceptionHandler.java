package umc.spring.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.exception.InvalidPageException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPageException.class)
    public ResponseEntity<ApiResponse<?>> handleInvalidPageException(InvalidPageException ex) {
        return ResponseEntity
                .badRequest()
                .body(ApiResponse.onFailure("INVALID_PAGE", ex.getMessage(),null));
    }
}
