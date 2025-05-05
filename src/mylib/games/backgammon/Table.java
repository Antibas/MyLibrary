package mylib.games.backgammon;

import java.util.Vector;

import mylib.games.chess.Color;
import mylib.math.Math2;
import mylib.util.pair.Pair;

public abstract class Table {
	public static final int SIZE = 12;
	//private final Vector<Piece>[] uppieces, downpieces;
	private Vector<Piece> pieces;
	public Table() {
		/*this.uppieces = new Vector[SIZE];
		for(int i = 0; i < SIZE; i++) {
			this.uppieces[i] = new Vector<>();
		}
		
		this.downpieces = new Vector[SIZE];
		for(int i = 0; i < SIZE; i++) {
			this.downpieces[i] = new Vector<>();
		}*/
		this.pieces = new Vector<>();
	}
	
	public Pair<Integer, Integer> throwDice() {
		return new Pair<>(Math2.RNG(1, 6), Math2.RNG(1, 6));
	}
	
	public abstract boolean canGo(Color color, Position from, Position to);
}
