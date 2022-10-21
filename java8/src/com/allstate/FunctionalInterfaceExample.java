/**
 * 
 */
package com.allstate;

/**
 * @author jayasreeveliyath
 *
 */
@FunctionalInterface
public interface FunctionalInterfaceExample {
	
    void say(String msg);
    
    // Can't have more than 1 abstract method if @FunctionalInterface is used.
    // void send(String msg);
}
