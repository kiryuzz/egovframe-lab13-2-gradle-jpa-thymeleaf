package lab.egovframe.web.controller;

import lab.egovframe.service.board.BoardService;
import lab.egovframe.web.dto.board.BoardSaveRequestDto;
import lab.egovframe.web.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class boardApiController {
    private final BoardService boardService;

    //등록
    @PostMapping("/api/post")
    public Long save(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }

    //삭제
    @DeleteMapping("/api/post/{no}")
    public Long delete(@PathVariable Long no) {
        boardService.delete(no);
        return no;
    }

    //수정
    @PutMapping("/api/post/{no}")
    public Long update(@PathVariable Long no, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(no, requestDto);
    }

}
