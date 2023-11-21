import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
// 클라이언트에게 전달
public class MemberResponseDto {
    private Long id;
    private String userName;
    private String name;
    private Long phone_number;

}

