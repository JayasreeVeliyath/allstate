/**
 * 
 */
package com.allstate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author jayasreeveliyath
 *
 */
public class ForEachExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("java8", "features");

        Consumer<String> printTextInHexConsumer = (String word) -> {
        	StringBuilder binary = new StringBuilder();
        	char[] chars = word.toCharArray();
        	for (char aChar : chars) {
        		binary.append(
        	            String.format("%8s", Integer.toBinaryString(aChar))
        	                    .replaceAll(" ", "0")
        	    );
        	}
            System.out.print(String.format("%n%-10s:%s", word, binary.toString()));
        };

        list.forEach(printTextInHexConsumer);

	}
}