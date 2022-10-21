/**
 * 
 */
package com.allstate;

/**
 * @author jayasreeveliyath
 *
 */
public interface InstagramInterface {

	static void viewInstagramPost(){
		System.out.println("Instagram Post.");
	}
	
	default void displayPic(){
		System.out.println("InstagramInterface DP.");
	}
}