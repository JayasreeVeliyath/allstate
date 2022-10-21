/**
 * 
 */
package com.allstate;

/**
 * @author jayasreeveliyath
 *
 */
public class DefaultAndStaticMethodsInInterfaceExample implements FacebookInterface, InstagramInterface {

	@Override
	public void displayPic() {
		InstagramInterface.super.displayPic();
	}

	@Override
	public void readFacebookPost() {
		System.out.println("Implemented readreadFacebookPost.");
		
	}

	// Not allowed.

//	@Override
//	public void displayPic() {
//		// TODO Auto-generated method stub
//		FacebookInterface.super.displayPic();
//	}
	
	public static void main(String[] args) {
		
		DefaultAndStaticMethodsInInterfaceExample defaultAndStaticMethodsInInterfaceExample = new DefaultAndStaticMethodsInInterfaceExample();
		// Displays InstagramInterface DP.
		defaultAndStaticMethodsInInterfaceExample.displayPic();

	}
}
