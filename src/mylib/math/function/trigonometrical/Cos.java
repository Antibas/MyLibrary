package mylib.math.function.trigonometrical;

import static mylib.math.function.trigonometrical.PhaseModifier.RADIANS;

import mylib.math.Math2;

public class Cos extends Sin {
	public Cos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cos(double amplitude, double frequency, double phase) {
		super(amplitude, frequency, phase);
		// TODO Auto-generated constructor stub
	}

	public Cos(double amplitude, double frequency) {
		super(amplitude, frequency);
		// TODO Auto-generated constructor stub
	}

	public Cos(double frequency) {
		super(frequency);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double apply(Double t) {
		return amplitude*Math.cos(frequency*t + this.getPhase())+adder;
	}
	
	@Override
	public String toString(String var) {
		return amplitude + "*cos(" + var + " + " + getPhase() +") + " + adder;
	}
}
