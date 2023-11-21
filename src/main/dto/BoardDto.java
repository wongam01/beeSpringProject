import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

//  게시글을 생성하거나 조회
public class BoardDto {
    private Long id;
    private String userName;
    private String email;
    private String title;
    private String context;

}
