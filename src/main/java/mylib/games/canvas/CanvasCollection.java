package mylib.games.canvas;

import mylib.games.cards.CardCollection;

public class CanvasCollection extends CardCollection<CanvasCard> {
    public CanvasCollection() {
        super(3);
    }

    public void reorderCards(int index1, int index2){
        CanvasCard tmp = elementAt(index1);
        set(index1, elementAt(index2));
        set(index2, tmp);
    }

    public CanvasCard complete() {
        if (size() < 3)
            throw new IllegalStateException("Not enough cards to complete");
        Symbol[] completedSymbols = new Symbol[5];
        String word1 = null, word2 = null;
        for (int i = 0; i < 5; i++) {
            for (CanvasCard c : this) {
                if (c.symbolAt(i) != null){
                    completedSymbols[i] = c.symbolAt(i);
                    break;
                }
                if(c.getWordPlacementLeft() && word1 == null){
                    word1 = c.getName();
                } else if(!c.getWordPlacementLeft() && word2 == null){
                    word2 = c.getName();
                }
            }
        }
        return new CanvasCard(word1 + " " + word2, completedSymbols);
    }
}
