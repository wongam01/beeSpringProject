import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository mr;
    private final PasswordEncoder passwordEncoder;
    // 회원 정보 저장 로직 구현
    public Member createUser(Member member) {
        return mr.save(member);
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
    public HttpStatus checkInfo(Member member, LoginDto loginDto) {
        if (member.getUserName().matches(loginDto.getUserName()) && member.getPassword().matches(loginDto.getPassword())) {
            return HttpStatus.OK;
        }else {
            return HttpStatus.BAD_REQUEST;
        }
    }


}
