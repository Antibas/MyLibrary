/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mylib.util;

import java.io.Serializable;

/**
 *
 * @author Antiv
 */
public interface Nameable extends Serializable{
    void setName(String name);
	String getName();
}
