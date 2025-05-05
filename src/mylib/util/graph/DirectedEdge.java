package mylib.util.graph;

public class DirectedEdge extends Edge {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2568313332093812420L;
	
	private Direction direction;
	
	public DirectedEdge(String name, double cost, Direction direction) {
		super(name, cost);
		this.direction = direction;
	}
	
	public DirectedEdge(String name, double cost) {
		this(name, cost, Direction.TO);
	}

	public DirectedEdge(String name) {
		this(name, 0, Direction.TO);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return super.toString() + ": " + direction.toString().toLowerCase();
	}

	

}
