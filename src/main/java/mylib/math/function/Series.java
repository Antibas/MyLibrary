package mylib.math.function;

import lombok.Getter;
import lombok.Setter;
import mylib.math.Number2;

@Setter
@Getter
public abstract class Series implements ISeries {
	protected double amplitude;
	protected double adder;
	protected Domain domain;
	
	public Series(double amplitude, double adder, Domain domain) {
		this.amplitude = amplitude;
		this.adder = adder;
		this.domain = domain;
	}
	
	public Series(double amplitude, double adder) {
		this(amplitude, adder, Number2.R_INT);
	}
	
	public Series(double amplitude) {
		this(amplitude, 0.0d);
	}
	
	public Series(Domain domain) {
		this(1.0d, 0.0d, domain);
	}
	
	public Series() {
		this(1.0d, 0.0d);
	}

    public Series add(Series f) {
		ISeries r = x -> this.apply(x) + f.apply(x);
		return (Series)r;
	}

    @Override
	public String toString() {
		return toString("n");
	}
	
	public abstract String toString(String var);
}
