import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // 검색을 위한 쿼리 메소드
    @Query("SELECT b FROM Board b WHERE b.title LIKE %?1% OR b.context LIKE %?1%")
    List<Board> findByTitleContainingOrContentContaining(String keyword);
}
