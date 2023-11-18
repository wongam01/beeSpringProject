import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "writer") //

public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String password;
    private String userName;
    private String email;
    private String title;
    private String context;
    @ManyToOne
    private Member writer;

    public BoardDto of() {
        return BoardDto.builder()
                .id(id)
                .email(email)
                .title(title)
                .context(context)
                .userName(writer.getUserName())
                .build();
    }


}
