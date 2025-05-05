package mylib.util.graph;


import mylib.util.Nameable;

public class Vertex implements Nameable, Comparable<Vertex>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private boolean isExplored;
	private double cost;
	
	public Vertex(String name, double cost) {
		this.name = name;
		this.isExplored = false;
		this.cost = cost;
	}
	
	public Vertex(String name) {
		this.isExplored = false;
		if(name.indexOf(':') != -1) {
			String tmp[] = name.split(":");
			this.name = tmp[0];
			this.cost = Double.parseDouble(tmp[1]);
		} else {
			this.name = name;
			this.cost = 0;
		}
	}

	public boolean isExplored() {
		return isExplored;
	}

	public void setExplored(boolean isExplored) {
		this.isExplored = isExplored;
	}
	
	public void reset() {
		this.isExplored = false;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return this.toString(false);
	}
	
	public String toString(boolean verbose) {
		if(verbose) {
			return name + ":"+cost+ "-> (" + isExplored + ")";
		}
		return name + ((cost == 0)?"":":"+cost);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vertex) {
			return ((Vertex)obj).name.equals(name);
		}
		
		if(obj instanceof String) {
			return ((String)obj).equals(name);
		}
		
		return false;
	}

	@Override
	public int compareTo(Vertex o) {
		return ((Double)cost).compareTo(o.cost);
	}
}
