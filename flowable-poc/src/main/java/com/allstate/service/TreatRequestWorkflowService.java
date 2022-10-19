/**
 * 
 */
package com.allstate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allstate.domain.Approval;
import com.allstate.domain.Treat;

/**
 * @author jayasreeveliyath
 *
 */

@Service
public class TreatRequestWorkflowService {
	
	private static Logger log = LoggerFactory.getLogger(TreatRequestWorkflowService.class);

	
	@Autowired
    private RuntimeService runtimeService;
 
    @Autowired
    private TaskService taskService;

    @Transactional
    public String treatRequest(Treat treat) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("requestor", treat.getRequestor());
        variables.put("treatName", treat.getTreatName());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("treatRequestReview", variables);
        
        log.info("Started process for requestor: {}", treat.getRequestor());
        return processInstance.getId();
    }
 
    @Transactional
    public List<Treat> getTreatRequests(String assignee) {
        List<Task> tasks = taskService.createTaskQuery()
          .taskCandidateGroup(assignee)
          .list();
        
        List<Treat> treatRequests = tasks.stream()
          .map(task -> {
              Map<String, Object> variables = taskService.getVariables(task.getId());
              return new Treat(
                task.getId(), (String) variables.get("requestor"), (String) variables.get("treatName"));
          })
          .collect(Collectors.toList());
        return treatRequests;
    }

    @Transactional
    public void reviewTreatRequest(Approval approval) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", approval.isStatus());
        
        taskService.complete(approval.getId(), variables);
        log.info("Completed process for id: {}", approval.getId());
    }
}