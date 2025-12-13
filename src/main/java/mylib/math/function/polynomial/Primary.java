/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib.math.function.polynomial;

import mylib.math.Complex;

/**
 *
 * @author User
 */
public class Primary extends Polynomial{
    
    public Primary(double a, double b){
        super(a, b);
    }
    
    public Primary(double a){
        super(a, 0.0);
    }
    
    public Primary(){
        super(1.0d, 0.0);
    }
    
    @Override
    public Complex[] solveForZero(){
        return new Complex[]{new Complex(-getMultiple(0) / getMultiple(1))};
    }
}
