/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib.math.randomvariable.count;

import java.util.Map;

import mylib.math.function.IMathFunction;

/**
 *
 * @author User
 */
public class RandomVariable extends mylib.math.randomvariable.RandomVariable<Double>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1764431765603471418L;
	
	private IMathFunction function;
	
	public RandomVariable(IMathFunction function) {
		super();
		this.function = function;
	}

	public RandomVariable(Map<? extends Double, ? extends Double> m) {
		super(m);
		this.function = (IMathFunction) m;
	}
	
	public double E() {
		return E(1);
	}
	
	public double E(int p) {
		double s = 0.0d;
		for(Double x: super.keySet()) {
			s += super.get(x)*Math.pow(x, p);
		}
		return s;
	}
	
	public IMathFunction M() {
		return (s) -> (new IMathFunction() {
			@Override
			public Double apply(Double t) {
				return Math.exp(s*t)*function.apply(t);
			}
		}).integral(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
    
	public double var() {
		return E(2) - Math.pow(E(), 2);
	}
}
