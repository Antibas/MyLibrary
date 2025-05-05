package mylib.games.solitaire;

import java.util.Arrays;
import java.util.Vector;

import mylib.games.cards.CardCollection;
import mylib.games.cards.standard.StandardCard;
import mylib.games.cards.standard.StandardDeck;

public class Solitaire {
	public static final int PILES_SIZE = 7, RESULTS_SIZE = 4;
	private StandardDeck deck;
	private Vector<CardCollection<StandardCard>> piles, results;
	private CardCollection<StandardCard> cards, cardsOpen;
	
	public Solitaire() {
		deck = new StandardDeck();
		deck.shuffle();
		
		results = new Vector<>(RESULTS_SIZE);
		
		piles = new Vector<>(PILES_SIZE);
		for(int i = 0; i < PILES_SIZE; i++) {
			piles.elementAt(i).addCards(deck.getTopCards(i+1));
		}
		
		cards = new CardCollection<StandardCard>(deck);
		cardsOpen = new CardCollection<StandardCard>();
	}

	@Override
	public String toString() {
		return "Solitaire \ndeck=" + deck + "\npiles=" + piles + "\nresults=" + results
				+ "\ncards=" + cards + "\ncardsOpen=" + cardsOpen;
	}
	
	
}