/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib.math.function;

import java.util.Vector;

import mylib.math.Complex;
import mylib.math.Number2;

/**
 *
 * @author User
 */
public interface Function extends java.util.function.Function<Double, Double>{
    
    public default Function derivative(){
        return derivative(Double.MIN_NORMAL);
    }
    
    public default Function derivative(double h){
        //ouble h = Double.MIN_NORMAL;
        return (x) -> (apply(x+h) - apply(x))/h;
    }
    
    public default Function derivative(int degree, double h){
        if(degree <= 0) throw new IllegalArgumentException();

        if(degree == 1) return derivative(h);
        return derivative(degree-1, h).derivative(h);
    }
    
    public default Function derivative(int degree){
        return derivative(degree, Double.MIN_NORMAL);
    }
    
    public default double integral(double a, double b){
        return integral(a, b, Number2.DX_DOUBLE);
    }
    
    public default double integral(double a, double b, double dx){
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
    
    public default Function integral(double a, double b, double dx, Function f){
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
    
    public default Function integral(double a, double b, Function f){
        return integral(a, b, Number2.DX_DOUBLE, f);
    }
    
    public default Function integral(){
        return (x) -> integral(0, x);
    }
    
    public default double limit(double l){
        return apply(l-Number2.DX_DOUBLE);
    }
    
    public default double limit(double l, char indicator){
        switch(indicator){
            case '-':
              return apply(l - Number2.DX_DOUBLE);  
            case '+':
                return apply(l + Number2.DX_DOUBLE);
            default:
                throw new IllegalArgumentException(""+indicator);
        }
        
    }
    
    public default Complex[] solveForZero(){
    	return solveForZero(Number2.R_DOUBLE);
    }
    
    public default Complex[] solveForZero(Domain domain){
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
    
    /*public default Series fourierSeries(double f0) {
    	double T0 = 1.0/f0;
    	Function f = t -> Math2.exp(new Complex(0, -2*Math.PI*f0*t)).multiply(f0*apply(t)).getRealPart();
    	return k -> f.integral(0, T0);
    }
    
    public default Function fourierTransport() {
    	return f ->
    }*/
}
