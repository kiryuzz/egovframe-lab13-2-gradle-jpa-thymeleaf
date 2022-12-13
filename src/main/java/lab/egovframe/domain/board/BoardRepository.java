package lab.egovframe.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query(value = "SELECT * FROM board ORDER BY no desc", nativeQuery = true)
    List<Board> findAllDesc();
}
