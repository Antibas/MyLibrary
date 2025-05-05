package mylib.math.function.trigonometrical;

import mylib.math.function.FunctionClass;

import static mylib.math.function.trigonometrical.PhaseModifier.*;

import mylib.math.Math2;

public class Sin extends FunctionClass{
	protected double amplitude;
	protected double adder;
	protected double frequency;
	protected double phase;
	public static PhaseModifier phaseModifier = RADIANS;
	
	public Sin(double amplitude, double frequency, double phase, double adder) {
		super(amplitude, adder);
		this.frequency = frequency;
		this.phase = phase;
	}
	
	public Sin(double amplitude, double frequency, double phase) {
		this(amplitude, frequency, phase, 0.0d);
	}
	
	public Sin(double amplitude, double frequency) {
		this(amplitude, frequency, 0.0d);
	}
	
	public Sin(double frequency) {
		this(1.0d, frequency, 0.0d);
	}
	
	public Sin() {
		this(1.0d, 1.0d, 0.0d);
	}
	
	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public double getPhase() {
		if(phaseModifier == DEGREES) {
			return 180.0d*phase/Math2.PI;
		}
		return phase;
	}

	public void setPhase(double phase) {
		if(phaseModifier == DEGREES) {
			this.phase = Math2.PI*phase/180.0d;
		}
		this.phase = phase;
	}
	
	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}

	public double getAdder() {
		return adder;
	}

	public void setAdder(double adder) {
		this.adder = adder;
	}

	@Override
	public Double apply(Double t) {
		if(phaseModifier == RADIANS) {
			return amplitude*Math.sin(frequency*t + phase) + adder;
			
		}
		return amplitude*Math.sin(frequency*t + Math2.PI*phase/180.0d) + adder;
	}
	
	@Override
	public String toString(String var) {
		return amplitude + "*sin(" + var + " + " + getPhase() +") + " + adder;
	}
}
