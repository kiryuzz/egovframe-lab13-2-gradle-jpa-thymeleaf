package lab.egovframe.web.dto.board;

import lab.egovframe.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private Long no;
    private String sub;
    private String name;
    private String content;

    @Builder
    public BoardSaveRequestDto(Long no, String sub, String name, String content) {
        this.no = no;
        this.sub = sub;
        this.name = name;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .no(no)
                .sub(sub)
                .name(name)
                .content(content)
                .build();
    }

}
