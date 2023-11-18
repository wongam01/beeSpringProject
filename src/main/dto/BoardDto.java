import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)


public class BoardDto {
    private Long id;
    private String userName;
    private String email;
    private String title;
    private String context;

}
