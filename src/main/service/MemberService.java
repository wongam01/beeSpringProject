import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository mr;

    // 회원 정보 저장 로직 구현
    public Member createUser(Member member) {
        return mr.save(Member.builder()
                .name(member.getName())
                .phone_number(member.getPhone_number())
                .resident_number(member.getResident_number())
                .id(member.getId())
                .password(member.getPassword())
                .build());
    }

    // dto -> entity 변환 메소드
    public Member convertToEntity(RegistrationDto registrationDto) {
       return Member.builder()
               .name(registrationDto.getName())
               .password(registrationDto.getPassword())
               .resident_number(registrationDto.getResident_number())
               .phone_number(registrationDto.getPhone_number())
               .userName(registrationDto.getUserName())
               .build();
    }
}
