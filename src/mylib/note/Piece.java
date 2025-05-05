package mylib.note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Piece extends ArrayList<Note>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -470419647627169985L;

	public Piece() {
		super();
	}

	public Piece(Note...notes) {
		super();
		for(Note note: notes)
			this.add(note);
	}
	
	public Piece(Collection<? extends Note> c) {
		super(c);
	}
	
	

}
