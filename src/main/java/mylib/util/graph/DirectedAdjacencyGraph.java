package mylib.util.graph;

import java.io.Serial;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import mylib.util.pair.Pair;

public class DirectedAdjacencyGraph<V extends Vertex, E extends DirectedEdge> extends AdjacencyGraph<V, E> {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = -5503984591246792910L;

	public DirectedAdjacencyGraph() {
		super();
	}

	public DirectedAdjacencyGraph(AdjacencyGraph<V, E> g) {
		super(g);
	}

	public DirectedAdjacencyGraph(Map<? extends V, ? extends HashSet<E>> m) {
		super(m);
	}

	public DirectedAdjacencyGraph(Pair<? extends V, ? extends E>... p) {
		super(p);
	}

	@Override
	public Set<E> incidentEdges(String vertex) {
		Set<E> inc = super.incidentEdges(vertex);
		for(E e: inc) {
			if(e.getDirection() == Direction.FROM) {
				inc.remove(e);
			}
		}
		return inc;
	}
}
