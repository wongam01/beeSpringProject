import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 사용자 정보조회 Dto
public class UserDto {
    @Id
    private Long id;
    private String userName;
    private String name;
}
