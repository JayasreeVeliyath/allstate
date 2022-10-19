/**
 * 
 */
package com.allstate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allstate.domain.Approval;
import com.allstate.domain.Treat;
import com.allstate.service.TreatRequestWorkflowService;

/**
 * @author jayasreeveliyath
 *
 */

@RestController
public class TreatRequestWorkflowController {
	
	@Autowired
    private TreatRequestWorkflowService treatRequestWorkflowService;
	
	@PostMapping("/treat-request")
    public String treatRequest(@Valid @RequestBody Treat treat) {
		return treatRequestWorkflowService.treatRequest(treat);
    }
 
    @PostMapping("/review-treat-request")
    public void reviewTreatRequest(@Valid @RequestBody Approval approval) {
    	treatRequestWorkflowService.reviewTreatRequest(approval);
    }
    
    @GetMapping("/treat-requests")
    public List<Treat> treatRequests(@RequestParam(required = true) String assignee) {
        return treatRequestWorkflowService.getTreatRequests(assignee);
    }

}
