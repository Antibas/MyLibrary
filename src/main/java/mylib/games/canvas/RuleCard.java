package mylib.games.canvas;

import lombok.Getter;
import lombok.Setter;
import mylib.games.cards.Card;

import java.util.List;
import java.util.function.Function;

@Setter
@Getter
public class RuleCard extends Card {
    private List<Integer> pointsPerColor;
    private Function<CanvasCard, Integer> rule;

    public RuleCard(String word, String description, List<Integer> pointsPerColor, Function<CanvasCard, Integer> rule) {
        super(word, description);
        this.pointsPerColor = pointsPerColor;
        this.rule = rule;
    }
}
