import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegistrationDto {
    // 회원가입 과정

    private String name;
    private String password;
    private String userName;
    private Long id;
    private Long phone_number;
    private Long resident_number;

}
