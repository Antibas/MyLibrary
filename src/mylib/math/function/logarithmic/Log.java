package mylib.math.function.logarithmic;

import lombok.Getter;
import lombok.Setter;
import mylib.math.Number2;
import mylib.math.function.FunctionClass;

@Setter
@Getter
public class Log extends FunctionClass{
	protected double base;
	
	public Log(double base, double amplitude, double adder) {
		super(amplitude, adder);
		this.base = base;
		this.setDomain((amplitude > 0)? Number2.R_PLUS_DOUBLE: Number2.R_MINUS_DOUBLE);
	}
	
	public Log(double base, double amplitude) {
		this(base, amplitude, 0.0d);
	}
	
	public Log(double base) {
		this(base, 1.0d, 0.0d);
	}

    @Override
	public Double apply(Double t) {
		return amplitude*Math.log10(t)/Math.log10(base) + adder;
	}
	
	@Override
	public String toString(String var) {
		return amplitude + "*log" + base + "(" + var + ") + " + adder;
	}
}
