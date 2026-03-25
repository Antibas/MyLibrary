package mylib.games.cards;

import mylib.games.canvas.RuleCard;

import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class CardCollection<T extends Card> extends Vector<T> {

	public CardCollection() {
		super();
	}

	public CardCollection(Collection<? extends T> c) {
		super(c);
	}

	public CardCollection(int initialCapacity) {
		super(initialCapacity);
	}

    @SafeVarargs
    public static <T extends Card> CardCollection<T> of(T... cards) {
        return new CardCollection<>(List.of(cards));
    }


    public T getTopCard(){
        return remove(0);
    }
       
    public Stack<T> getTopCards(int n){
        Stack<T> ret = new Stack<>();
        for(int i = 0; i < n; i++)
            ret.addElement(getTopCard());
        return ret;
    }
    
    public int remainingCards(){
        return capacity()-size();
    }

	public void addCards(Collection<T> topCards) {
		this.addAll(topCards);
	}

    
}
