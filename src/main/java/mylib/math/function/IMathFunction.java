/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib.math.function;

import java.util.List;
import java.util.Vector;
import java.util.function.Function;

import mylib.math.Complex;
import mylib.math.Number2;

/**
 *
 * @author User
 */
public interface IMathFunction extends Function<Double, Double> {
    
    default IMathFunction derivative(){
        return derivative(Double.MIN_NORMAL);
    }
    
    default IMathFunction derivative(double h){
        //ouble h = Double.MIN_NORMAL;
        return (x) -> (apply(x+h) - apply(x))/h;
    }
    
    default IMathFunction derivative(int degree, double h){
        if(degree <= 0) throw new IllegalArgumentException();

        if(degree == 1) return derivative(h);
        return derivative(degree-1, h).derivative(h);
    }
    
    default IMathFunction derivative(int degree){
        return derivative(degree, Double.MIN_NORMAL);
    }
    
    default double integral(double a, double b){
        return integral(a, b, Number2.DX_DOUBLE);
    }
    
    default double integral(double a, double b, double dx){
        if(a > b){
            double tmp = a;
            a = b;
            b = tmp;
        }
        double S = 0.0;
        
        for(double i = a; i <= b; i += dx){
            S += apply(i + dx/2.0)*dx;
        }
        
        return (a > b)? -S : S;
    }
    
    default IMathFunction integral(double a, double b, double dx, IMathFunction f){
        if(a > b){
            double tmp = a;
            a = b;
            b = tmp;
        }
        double S = 0.0;
        
        for(double i = a; i <= b; i += dx){
            S += apply(i + dx/2.0)*dx;
        }
        
        return x -> 0.0d;
    }
    
    default IMathFunction integral(double a, double b, IMathFunction f){
        return integral(a, b, Number2.DX_DOUBLE, f);
    }
    
    default IMathFunction integral(){
        return (x) -> integral(0, x);
    }
    
    default double limit(double l){
        return apply(l-Number2.DX_DOUBLE);
    }
    
    default double limit(double l, char indicator){
        switch(indicator){
            case '-':
              return apply(l - Number2.DX_DOUBLE);  
            case '+':
                return apply(l + Number2.DX_DOUBLE);
            default:
                throw new IllegalArgumentException(""+indicator);
        }
        
    }
    
    default Complex[] solveForZero(){
    	return solveForZero(Number2.R_DOUBLE);
    }
    
    default Complex[] solveForZero(Domain domain){
    	Vector<Complex> solutions = new Vector<>();
    	
    	double f;
    	for(double x = domain.getStart(); x <= domain.getEnd(); x += domain.getDx()) {
    		f = apply(x);
    		if(f == 0.0d) {
    			solutions.add(new Complex(x));
    		}
    	}
    	
        return (Complex[]) solutions.toArray();
    }

    default boolean isOneToOne(){
        return isOneToOne(Number2.R_DOUBLE);
    }

    default boolean isOneToOne(Domain domain){
        List<Double> points = new Vector<>();
        for(double x = domain.getStart(); x <= domain.getEnd(); x += domain.getDx()) {
            points.add(apply(x));
        }
        return points.stream().distinct().count() == 1;
    }
    
    /*default Series fourierSeries(double f0) {
    	double T0 = 1.0/f0;
    	Function f = t -> Math2.exp(new Complex(0, -2*Math.PI*f0*t)).multiply(f0*apply(t)).getRealPart();
    	return k -> f.integral(0, T0);
    }
    
    default Function fourierTransport() {
    	return f ->
    }*/
}
