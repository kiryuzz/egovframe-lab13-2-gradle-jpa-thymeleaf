package lab.egovframe.service.board;

import lab.egovframe.domain.board.Board;
import lab.egovframe.domain.board.BoardRepository;
import lab.egovframe.web.dto.board.BoardListResponseDto;
import lab.egovframe.web.dto.board.BoardResponseDto;
import lab.egovframe.web.dto.board.BoardSaveRequestDto;
import lab.egovframe.web.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllDesc() {
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getNo();
    }

    public BoardResponseDto findById(Long no) {
        Board entity = boardRepository.findById(no).orElseThrow();
        return new BoardResponseDto(entity);
    }

    @Transactional
    public void delete(Long no) {
        Board entity = boardRepository.findById(no).orElseThrow();
        boardRepository.delete(entity);
    }

    @Transactional
    public Long update(Long no, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(no).orElseThrow();
        board.update(requestDto.getSub(), requestDto.getName(), requestDto.getContent());
        return no;
    }
}
