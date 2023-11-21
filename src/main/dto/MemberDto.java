import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto {
    // 회원 정보 조회나 업데이트 등의 기능 Dto
    @Id
    private String name;
    private String password;
    private Long id;
    private Long phone_number;
    private Long resident_number;

}
