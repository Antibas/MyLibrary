package mylib.games.canvas;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Symbol {
    private List<Mark> marks;

    public Symbol(Mark mark, Mark secondMark) {
        this.marks = List.of(mark, secondMark);
    }

    public Symbol(Mark mark) {
        this.marks = List.of(mark);
    }
}
