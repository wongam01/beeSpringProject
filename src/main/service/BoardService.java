import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository br; // getter , setter X



    // Board 엔티티 저장 로직 구현
     public Board createBoard(BoardDto dto) {
        return br.save(Board.builder()
                .id(dto.getId())
                .userName(dto.getUserName())
                .title(dto.getTitle())
                .context(dto.getContext())
                .build());
    }

    // 전체 조회 기능
    @Transactional(readOnly = true)
    public List<Board> getAllBoard() {
        return br.findAll();
    }

    // id 별 조회 기능 로직 구현
    // 1. Id 를 통해 update 할 객체를 찾음
    // 2. deviceDto 를 이욯해 Device 필드의 객체를 업데이트한다.
    // 3. 업데이트 된 Device 를 DB에 저장
    // 4. Device 를 DeviceDto 로 변환
    public Board getBoardById(Long id) {

        return br.findById(id).get();
    }

    public Board updateBoard(Long id, BoardDto boardDto) {
        Optional<Board> optionalBoard = br.findById(id);
        Board board = optionalBoard.get();
        board.setUserName(boardDto.getUserName());
        board.setTitle(board.getTitle());
        board.setContext(board.getContext());
        Board updatedBoard = br.save(board);
        return updatedBoard;
    }

}
