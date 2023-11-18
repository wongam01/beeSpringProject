import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/service")

public class BoardRestController {
    private final BoardService boardService;

    // 회원가입 기능 로직

    // 로그인 기능 로직


    // 전체 게시물 로직
    @GetMapping()
    public ResponseData.ApiResult<?> getAllBoard() {
        return ResponseData.success(boardService.getAllBoard()
                .stream()
                .map(Board::of)
                .toList(), "게시글 조회");
    }

    // 게시판 생성 로직
    @PostMapping("/new")
    public ResponseData.ApiResult<?> createBoard(@RequestBody BoardDto dto) {
        if (dto.getUserName() == null) {
            return ResponseData.error("유저 이름을 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        BoardDto boardDto = boardService.createBoard(dto).of();
        return ResponseData.success(boardDto,"생성되었습니다");
    }
}
