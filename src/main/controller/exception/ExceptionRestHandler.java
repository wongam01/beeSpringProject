package exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.http.HttpResponse;

@RestControllerAdvice
@Slf4j
public class ExceptionRestHandler {
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseData.ApiResult<?> idNotFoundException(IdNotFoundException e) {
        log.error("IdNotFoundException = {}", e.getMessage());
        return Respon
    }


}
