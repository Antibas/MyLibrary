package mylib.util.itemset;

public class Item {
	private double weight;
	private double benefit;
	
	public Item(double weight, double benefit) {
		this.weight = weight;
		this.benefit = benefit;
	}
	
	

	public Item() {
		this(0, 0);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBenefit() {
		return benefit;
	}

	public void setBenefit(double benefit) {
		this.benefit = benefit;
	}
	
	public double getValue() {
		if(weight == 0) return 0;
		return benefit / weight;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(benefit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item itm = (Item)obj;
			return itm.weight == this.weight && itm.benefit == this.benefit;
		}
		return false;
	}



	@Override
	public String toString() {
		return "[" + weight + ", " + benefit + "]";
	}
	
	
	
	
}
