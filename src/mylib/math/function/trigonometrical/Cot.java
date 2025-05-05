package mylib.math.function.trigonometrical;

import static mylib.math.function.trigonometrical.PhaseModifier.RADIANS;

import mylib.math.Math2;

public class Cot extends Sin {
	@Override
	public Double apply(Double t) {
		if(phaseModifier == RADIANS) {
			return amplitude/Math.tan(frequency*t + phase)+adder;
		}
		return amplitude/Math.tan(frequency*t + Math2.PI*phase/180.0d)+adder;
	}
	
	@Override
	public String toString(String var) {
		return amplitude + "*cot(" + var + " + " + getPhase() +") + " + adder;
	}
}
