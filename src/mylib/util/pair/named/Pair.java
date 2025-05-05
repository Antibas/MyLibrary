package mylib.util.pair.named;

import java.util.Collection;
import java.util.Iterator;

public class Pair<V> extends mylib.util.pair.Pair<V, V> implements Iterable<V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4487931904493274585L;

	public Pair(V first, V second) {
		super(first, second);
	}

	@Override
	public Iterator<V> iterator() {
		return new Iterator<>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				return i < 2;
			}

			@Override
			public V next() {
				return (i++ == 0)?Pair.this.first:Pair.this.second;
			}
		};
	}

}
