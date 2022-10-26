/**
 * 
 */
package com.allstate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author jayasreeveliyath
 *
 */
public class StreamAPIExample {
	
	static class Department {
		
	  
		private String name;
		private long revenue;
		public Department(String string, long revenue) {
			
			this.setName(string);
			this.setRevenue(revenue);
		}
		/**
		 * @return the revenue
		 */
		public long getRevenue() {
			return revenue;
		}
		/**
		 * @param revenue the revenue to set
		 */
		public void setRevenue(long revenue) {
			this.revenue = revenue;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		   
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StreamAPIExample.filter();
		StreamAPIExample.reduce();
	}
	
	static void filter() {
				
		List<String> words = Arrays.asList("five", "gloomy", "tree", "keep", "cheerful", "cool", "weak", "encouraged", "confident");
	    System.out.println("Original list: " + words);
	    List<String> fourLetterWords = words.stream()
	                                .filter(word -> word.length() == 4)
	                                .collect(Collectors.toList());
	  
	    System.out.println("Processed list, only 4 letter words: " + fourLetterWords);
	   
	}
	
	static void reduce() {
		List<Department> departments = Arrays.asList(
				new Department("Sales", 2000000L), 
				new Department("Marketing", 1200000L),
				new Department("IT", 300000L), 
				new Department("Operations", 900000L));
		
		Optional<Department> result = departments.stream()
				.reduce((department1, department2) -> 
				department1.getRevenue() > department2.getRevenue() ?  department1: department2);
		
		System.out.println("Department with highest revenue is: '" + result.get().name + "' and the revenue is: '" +result.get().revenue + "'.");
	}
 }
 