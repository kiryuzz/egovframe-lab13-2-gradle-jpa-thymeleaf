package lab.egovframe.domain.board;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 50)
    private String name;

    @Column(length = 100)
    private String sub;

    @Column(length = 4000)
    private String content;

    @Builder
    public Board(Long no, String name, String sub, String content) {
        this.no = no;
        this.name = name;
        this.sub = sub;
        this.content = content;
    }

    public void update(String sub, String name, String content) {
        this.no = no;
        this.sub = sub;
        this.name = name;
        this.content = content;
    }
}
