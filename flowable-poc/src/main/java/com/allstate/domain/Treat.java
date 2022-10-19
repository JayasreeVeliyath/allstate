/**
 * 
 */
package com.allstate.domain;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jayasreeveliyath
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Treat {
	
	@NotBlank(message = "Id is required.")
	private String id;
	
	@NotBlank(message = "Requestor is required.")
	private String requestor;
	
	@NotBlank(message = "Treat name is required.")
	private String treatName;

}
