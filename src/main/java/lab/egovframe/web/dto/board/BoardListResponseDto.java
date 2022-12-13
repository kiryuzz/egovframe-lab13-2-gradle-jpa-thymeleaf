package lab.egovframe.web.dto.board;

import lab.egovframe.domain.board.Board;
import lombok.Getter;

@Getter
public class BoardListResponseDto {
    private Long no;
    private String sub;
    private String name;

    public BoardListResponseDto(Board entity) {
        this.no = entity.getNo();
        this.sub = entity.getSub();
        this.name = entity.getName();
    }
}
