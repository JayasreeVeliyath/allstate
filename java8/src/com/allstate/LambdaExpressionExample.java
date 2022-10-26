/**
 * 
 */
package com.allstate;

/**
 * @author jayasreeveliyath
 *
 */
public class LambdaExpressionExample {
	
	public static void main(String args[])
    {
		FunctionalInterface functionalInterface = (String name)->System.out.println("Hello, "+name);
  
		functionalInterface.printName("John Doe");
    }

	
	interface FunctionalInterface
	{
	    void printName(String name);
	}

}
