import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Long phone_number;
    private Long resident_number;
    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    public MemberDto of1() {
        return MemberDto.builder()
                .id(id)
                .name(name)
                .password(password)
                .phone_number(phone_number)
                .resident_number(resident_number)
                .build();
    }

}
