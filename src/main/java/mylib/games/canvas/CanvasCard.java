package mylib.games.canvas;

import lombok.Getter;
import lombok.Setter;
import mylib.games.cards.Card;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
public class CanvasCard extends Card {
    public static final List<Color> colorIndices = List.of(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PURPLE);

    private final Symbol[] symbols;
    private final Boolean wordPlacementLeft;
    public CanvasCard(String word, Boolean wordPlacementLeft, Symbol... symbols) {
        super(word);
        assert symbols.length == 5;
        this.symbols = symbols;
        this.wordPlacementLeft = wordPlacementLeft;
    }

    public CanvasCard(String word, Symbol... symbols) {
        this(word, null, symbols);
    }

    public Symbol symbolAt(int i) {
        return symbols[i];
    }

    public int getMarkSize(Mark mark){
        return Arrays.stream(symbols)
                .filter(Objects::nonNull)
                .filter(s -> s.getMarks().stream().anyMatch(m -> m.equals(mark)))
                .map(s -> s.getMarks().stream().allMatch(m -> m.equals(mark))?2:1)
                .reduce(0, Integer::sum);
    }
}
