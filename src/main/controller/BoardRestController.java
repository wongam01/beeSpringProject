import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/board/service")
@Slf4j
@RestController
public class BoardRestController {
    private final BoardService boardService;
    private final MemberService memberService;
// 회원 가입 기능 로직
    @PostMapping("/signup")
    public ResponseData.ApiResult<?> createUser(@RequestBody RegistrationDto registrationDto) {
        // 핸드폰 번호 미기입 시
        if (registrationDto.getPhone_number() == null) {
            return ResponseData.error("번호를 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        // 비밀번호에 특수문자 없을 시
        if (!registrationDto.getPassword().matches("^[a-zA-Z0-9]*$")) {
            return ResponseData.error("특수문자를 포함시켜주세요", HttpStatus.BAD_REQUEST);
        }
        // 이름 미기입 시
        if (registrationDto.getName() == null) {
            return ResponseData.error("이름을 기입해주세요", HttpStatus.BAD_REQUEST);
        }
        // 엔티티로 변환
        Member member = memberService.convertToEntity(registrationDto);

        // 회원가입 처리 -> DB에 영속화
        Member savedMember = memberService.createUser(member);

        // 저장된 Member 엔티티를 MemberResponseDto로 변환
        MemberResponseDto responseDto = converToMemberResponseDto(savedMember);
        return ResponseData.success(responseDto,"회원가입이 완료되었습니다");
    }

    private MemberResponseDto converToMemberResponseDto(Member member) {
        // member -> MemberResponseDto 로 변환
        return new MemberResponseDto(
                member.getId(),
                member.getUserName(),
                member.getName(),
                member.getPhone_number()
        );
    }

    // 로그인 기능 로직
    // password -> 해시 형태
    // 유효 -> 성공 결과 반환
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        Member member = memberService.login(loginDto.getUserName(), loginDto.getPassword());
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.badRequest().body("로그인 실패 : 사용자 이름 또는 비밀번호가 잘못되었습니다");
        }

    }

    // 전체 게시물 로직
    @GetMapping()
    public ResponseData.ApiResult<?> getAllBoard() {
        return ResponseData.success(boardService.getAllBoard()
                .stream()
                .toList(), "게시글 조회");
    }

    // 게시판 생성 로직
    @PostMapping("/new")
    public ResponseData.ApiResult<?> createBoard(@RequestBody BoardDto dto) {
        if (dto.getUserName() == null) {
            return ResponseData.error("유저 이름을 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        BoardDto boardDto = boardService.createBoard(dto).of();
        return ResponseData.success(boardDto, "생성되었습니다");
    }

    // 게시물 삭제 로직

}
