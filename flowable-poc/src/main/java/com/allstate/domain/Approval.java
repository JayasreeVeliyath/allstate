/**
 * 
 */
package com.allstate.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class Approval {

	@NotBlank(message = "Id is required.")
    private String id;
	
	@NotNull(message = "Status is required.")
    private boolean status;
}
