package mylib.math.function.trigonometrical;

import static mylib.math.function.trigonometrical.PhaseModifier.RADIANS;

import mylib.math.Math2;

public class Tan extends Sin {
	public Tan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tan(double amplitude, double frequency, double phase) {
		super(amplitude, frequency, phase);
		// TODO Auto-generated constructor stub
	}

	public Tan(double amplitude, double frequency) {
		super(amplitude, frequency);
		// TODO Auto-generated constructor stub
	}

	public Tan(double frequency) {
		super(frequency);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double apply(Double t) {
		if(phaseModifier == RADIANS) {
			return amplitude*Math.tan(frequency*t + phase)+adder;
		}
		return amplitude*Math.tan(frequency*t + Math2.PI*phase/180.0d)+adder;
	}
	
	@Override
	public String toString(String var) {
		return amplitude + "*tan(" + var + " + " + getPhase() +") + " + adder;
	}
}
