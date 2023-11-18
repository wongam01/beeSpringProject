import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Setter
@Getter

public class ResponseData {
    public static <T> ApiResult<T> success(T data, String msg) {
        return new ApiResult<>(true, msg, data, null);
    }
    public static ApiResult<?> error(String msg, HttpStatus status) {
        return new ApiResult<>(false, null, null, new ApiError(status, msg));
    }
    // record == (static)class + Getter + Setter + hashCode + equals + toString
    public record ApiResult<T>(boolean success, String message, T data, ApiError error) {
    }
    @Getter
    @ToString
    public static class ApiError {
        private final int code;
        private final HttpStatus status;
        private final String message;
        public ApiError(HttpStatus status, String message) {
            this.status = status;
            this.code = status.value();
            this.message = message;
        }
    }
}
