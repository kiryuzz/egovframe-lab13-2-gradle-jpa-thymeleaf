package lab.egovframe.web.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private Long no;
    private String sub;
    private String name;
    private String content;

    @Builder
    public BoardUpdateRequestDto(Long no, String sub, String name, String content) {
        this.no = no;
        this.sub = sub;
        this.name = name;
        this.content = content;
    }
}
