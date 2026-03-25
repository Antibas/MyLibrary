package mylib.games.canvas;

import lombok.Getter;
import mylib.games.cards.CardCollection;
import mylib.games.cards.Deck;

import java.util.*;
import java.util.stream.Stream;

@Getter
public class Field {
    // TODO fill
    public final static Deck<CanvasCard> canvasCardsDeck = Deck.of(
        new CanvasCard(
                "Impressive",
                true,
                new Symbol(Mark.PER_GEAR),
                null,
                new Symbol(Mark.RAINBOW),
                null,
                null),
        new CanvasCard(
                "Curiosity",
                false,
                null,
                null,
                new Symbol(Mark.RAINBOW),
                new Symbol(Mark.RAINBOW, Mark.GEAR),
                null
        )
    );

    public final static Deck<RuleCard> ruleCardsDeck = Deck.of(
        new RuleCard(
                "Style",
                "SQ + SQ + SQ",
                List.of(4, 10, 18),
                canvasCard -> {
                    assert canvasCard.getWordPlacementLeft() == null;
//                    for(Symbol s : canvasCard.getSymbols()){
//                        if(s != null && (s.getMark().equals(Mark.SQUARE) || s.getSecondMark().equals(Mark.SQUARE))){
//                            squares += (s.getMark().equals(Mark.SQUARE) && s.getSecondMark().equals(Mark.SQUARE)?2:1);
//                        }
//                    }
                    return canvasCard.getMarkSize(Mark.SQUARE)/3;
                }
        ),
        new RuleCard(
                "Proximity",
                "SQ GR or GR SQ",
                List.of(2, 5, 8, 12),
                canvasCard -> {
                    assert canvasCard.getWordPlacementLeft() == null;
                    int pairs = 0;
                    Symbol s, snext;
                    for(int i = 0; i < 4; i++){
                        s = canvasCard.symbolAt(i);
                        snext = canvasCard.symbolAt(i+1);
                        if(s != null && snext != null) {
                            if ((s.getMarks().contains(Mark.SQUARE) && snext.getMarks().contains(Mark.GEAR))
                            || (s.getMarks().contains(Mark.GEAR) && snext.getMarks().contains(Mark.SQUARE))) {
                                pairs++;
                            }
                        }
                    }
                    return pairs;
                }
        ),
        new RuleCard(
                "Emphasis",
                "Exactly 1 RB",
                List.of( 1, 4, 11),
                canvasCard -> {
                    assert canvasCard.getWordPlacementLeft() == null;
                    return canvasCard.getMarkSize(Mark.RAINBOW) == 1? 1 : 0;
                }
        ),
        new RuleCard(
                "Repetition",
                "TR + TR",
                List.of(3, 7, 11, 16),
                canvasCard -> {
                    assert canvasCard.getWordPlacementLeft() == null;
                    return canvasCard.getMarkSize(Mark.RAINBOW) == 1? 1 : 0;
                }
        ),
        new RuleCard(
                "Variety",
                "RB + TR + SQ + GR",
                List.of(4, 8, 13),
                canvasCard -> {
                    assert canvasCard.getWordPlacementLeft() == null;
                    List<Integer> marksList = List.of(
                            canvasCard.getMarkSize(Mark.RAINBOW),
                            canvasCard.getMarkSize(Mark.TRIANGLE),
                            canvasCard.getMarkSize(Mark.SQUARE),
                            canvasCard.getMarkSize(Mark.GEAR)
                    );
                    if(marksList.stream().anyMatch(i -> i == 0)) return 0;
                    if(marksList.stream().allMatch(i -> i >= 2)) return 2;
                    return 1;
                }
        ),
        new RuleCard(
                "Composition",
                "All color columns are filled",
                List.of(4, 8, 13),
                canvasCard -> {
                    assert canvasCard.getWordPlacementLeft() == null;
                    return Arrays.stream(canvasCard.getSymbols()).anyMatch(Objects::nonNull)? 1 : 0;
                }
        )

    );

    public final static List<Color> ruleCardColors = List.of(Color.RED, Color.GREEN, Color.BLUE, Color.PURPLE);

    private final Player[] players;
    private final CardCollection<RuleCard> rules;
    private final CardCollection<CanvasCard> canvasCards;

    public Field(String... playerNames){
//        this.players = new Player[playerNames.length];
//        for(int i = 0; i < playerNames.length; i++){
//            this.players[i] = new Player(playerNames[i]);
//        }
        this.players = Arrays.stream(playerNames).map(Player::new).toArray(Player[]::new);
        this.rules = new CardCollection<>(ruleCardsDeck.getTopCards(4));
        this.canvasCards = new CardCollection<>(canvasCardsDeck.getTopCards(5));

    }

    public void drawCard(int playerIndex, int canvasIndex){
        if(players[playerIndex].getCanvasTokens() < canvasIndex)
            throw new IllegalArgumentException("Player has no canvas tokens");
        players[playerIndex].addCard(canvasCards.remove(canvasIndex));
        canvasCards.addLast(canvasCardsDeck.getTopCard());
    }

    public void completeCanvas(int playerIndex, int canvasIndex){
        CanvasCard completed = players[playerIndex].getCanvasCollection(canvasIndex).complete();
//        RuleCard rule;
//        for(int i = 0; i < 4; i++){
//            rule = rules.get(i);
//            if(rule.getRule().apply(completed) != 0){
//                players[playerIndex].addColor(rule.getRule().apply(completed), ruleCardColors.get(i));
//            }
//        }
        rules
            .stream()
            .filter(rule -> rule.getRule().apply(completed) != 0)
            .forEach(rule -> {
                players[playerIndex].addColor(rule.getRule().apply(completed), ruleCardColors.get(rules.indexOf(rule)));
            });

        List<Symbol> perSymbols = Arrays.stream(completed.getSymbols())
                .filter(s -> s != null && s.getMarks().stream().anyMatch(Mark::isIncluded))
                .toList();


        List<Mark> marks = Arrays.stream(completed.getSymbols())
                .map(Symbol::getMarks)
                .reduce((l1, l2) -> Stream.concat(l1.stream(), l2.stream()).toList())
                .orElse(List.of());
//        int innerMarks;
//        for(Symbol s: perSymbols){
//            innerMarks = marks.stream().filter(m -> s.getMarks().stream().anyMatch(m2 -> m2.getIncludedMark().equals(m))).toList().size();
//            players[playerIndex].addColor(innerMarks, Color.GRAY);
//        }
        perSymbols.stream().map(
                s -> marks
                        .stream()
                        .filter(
                                m -> s
                                        .getMarks()
                                        .stream()
                                        .anyMatch(m2 -> m2.getIncludedMark().equals(m)
                                        )
                        )
                        .toList()
                        .size()
        ).forEach(
                innerMarks -> players[playerIndex].addColor(innerMarks, Color.GRAY)
        );
    }

    public int getPoints(int playerIndex){
        RuleCard rule;
        int points = 0, colorSize;
        for (int i = 0; i < 4; i++) {
            rule = rules.get(i);
            Color color = ruleCardColors.get(i);
            colorSize = players[playerIndex].getColorTokens().stream().filter(c -> c.equals(color)).toList().size();
            if(colorSize != 0){
                points += colorSize <= rule.getPointsPerColor().size()?
                        rule.getPointsPerColor().get(colorSize):
                        rule.getPointsPerColor().stream().max(Comparator.comparing(Integer::intValue)).orElse(0);
            }
        }
        colorSize = players[playerIndex].getColorTokens().stream().filter(c -> c.equals(Color.GRAY)).toList().size();
        if(colorSize != 0){
            points += colorSize*2;
        }
        return points;
    }

}
