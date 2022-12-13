package lab.egovframe.web.dto.board;

import lab.egovframe.domain.board.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long no;
    private String sub;
    private String name;
    private String content;

    public BoardResponseDto(Board entity) {
        this.no = entity.getNo();
        this.sub = entity.getSub();
        this.name = entity.getName();
        this.content = entity.getContent();
    }
}
