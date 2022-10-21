/**
 * 
 */
package com.allstate;

/**
 * @author jayasreeveliyath
 *
 */
public interface FacebookInterface {
		
	default void displayPic(){
		System.out.println("Facebook DP.");

	}
	
	void readFacebookPost();
}
