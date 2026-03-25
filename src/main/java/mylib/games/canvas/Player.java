package mylib.games.canvas;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player {
    private final String name;
    private final CanvasCollection[] canvasCards;
    private final List<CanvasCard> hand;
    private int canvasTokens;
    private final List<Color> colorTokens;

    public Player(String name){
        this.name = name;
        this.canvasCards = new CanvasCollection[3];
        for(int i = 0; i < 3; i++)
            this.canvasCards[i] = new CanvasCollection();
        this.hand = new ArrayList<>(5);
        this.canvasTokens = 4;
        this.colorTokens = new ArrayList<>();
    }

    public CanvasCollection getCanvasCollection(int i){
        return canvasCards[i];
    }

    public boolean addCard(CanvasCard c){
        return hand.add(c);
    }

    public int payCanvasTokens(int tokens){
        canvasTokens -= tokens;
        return canvasTokens;
    }

    public int gainCanvasTokens(int tokens){
        canvasTokens += tokens;
        return canvasTokens;
    }

    public void addColor(Color m){
        colorTokens.add(m);
    }

    public void addColor(int times, Color m){
        for(int t = 0; t < times; times++){
            colorTokens.add(m);
        }
    }

//    public boolean addCardToCanvasCollection(int i, CanvasCard c){
//        return canvasCards[i].add(c);
//    }
//
//    public void complete(int i){
//        CanvasCard completed = canvasCards[i].complete();
//    }
}
