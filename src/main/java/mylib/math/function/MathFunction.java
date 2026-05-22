package mylib.math.function;

// Remove Lombok annotations and generate getters/setters manually
import lombok.Getter;
import lombok.Setter;
import mylib.math.Number2;

@Setter
@Getter
public abstract class MathFunction implements IMathFunction {

    protected double amplitude;
	protected double adder;
	protected Domain domain;
	
	public MathFunction(double amplitude, double adder, Domain domain) {
		this.amplitude = amplitude;
		this.adder = adder;
		this.domain = domain;
	}
	
	public MathFunction(double amplitude, double adder) {
		this(amplitude, adder, Number2.R_DOUBLE);
	}
	
	public MathFunction(double amplitude) {
		this(amplitude, 0.0d);
	}
	
	public MathFunction(Domain domain) {
		this(1.0d, 0.0d, domain);
	}
	
	public MathFunction() {
		this(1.0d, 0.0d);
	}

    public MathFunction add(MathFunction f) {
		IMathFunction r = x -> this.apply(x) + f.apply(x);
		return (MathFunction)r;
	}

	@Override
	public String toString() {
		return toString("x");
	}
	
	public abstract String toString(String var);
}
