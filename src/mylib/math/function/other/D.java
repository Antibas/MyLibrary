package mylib.math.function.other;

import mylib.math.function.FunctionClass;

public class D extends FunctionClass{
	protected double t0;

	public D(double t0, double amplitude, double adder) {
		super(amplitude, adder);
		this.t0 = t0;
	}

	public D(double t0, double amplitude) {
		this(t0, amplitude, 0.0d);
	}
	
	public D(double t0) {
		this(t0, 1.0d, 0.0d);
	}
	
	public D() {
		this(0.0d, 1.0d, 0.0d);
	}
	
	public double getT0() {
		return t0;
	}

	public void setT0(double t0) {
		this.t0 = t0;
	}

	@Override
	public Double apply(Double t) {
		double p = (t == t0)? 1.0d : 0.0d;
		return amplitude*p + adder;
	}
	
	@Override
	public String toString(String var) {
		return amplitude + "*d(" + var + ") + " + adder;
	}

}
