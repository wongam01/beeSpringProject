import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository mr;
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

    public Member login(String userName, String password) {
        Member member = findMemberByUserName(userName);
        if (member != null && member.getPassword().equals(password)) {
            return member; // 로그인 성공
        }
        return null; // 로그인 실패
    }

    private Member findMemberByUserName(String userName) {
        Optional<Member> memberOptional = mr.findByUserName(userName);
        if (memberOptional.isPresent()) {
            return memberOptional.get();
        } else {
            return null;
        }

    }



}
