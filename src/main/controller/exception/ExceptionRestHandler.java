
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionRestHandler {
    @ExceptionHandler(exception.IdNotFoundException.class)
    public ResponseData.ApiResult<?> idNotFoundException(exception.IdNotFoundException e) {
        log.error("IdNotFoundException = {}", e.getMessage());
        return ResponseData.error(e.getMessage(), HttpStatus.NOT_FOUND);
    }


}
