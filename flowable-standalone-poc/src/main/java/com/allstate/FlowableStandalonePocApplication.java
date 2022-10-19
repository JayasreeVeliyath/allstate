/**
 * 
 */
package com.allstate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.api.Task;

/**
 * @author jayasreeveliyath
 *
 */
public class FlowableStandalonePocApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
			      .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
			      .setJdbcUsername("admin")
			      .setJdbcPassword("password")
			      .setJdbcDriver("org.h2.Driver")
			      .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

	    ProcessEngine processEngine = cfg.buildProcessEngine();
	    
	    RepositoryService repositoryService = processEngine.getRepositoryService();
	    Deployment deployment = repositoryService.createDeployment()
	      .addClasspathResource("treat-request-workflow.bpmn20.xml")
	      .deploy();
	    
	    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
	    		  .deploymentId(deployment.getId())
	    		  .singleResult();
	    System.out.println("Found process definition : " + processDefinition.getName());
	    Scanner scanner= new Scanner(System.in);
	    
	    try {
		    System.out.println("Who is the requestor?");
		    String requestor = scanner.nextLine();
	
		    System.out.println("What treat do you want?");
		    String treatName = scanner.nextLine();
	
		    RuntimeService runtimeService = processEngine.getRuntimeService();
	
		    Map<String, Object> variables = new HashMap<String, Object>();
		    variables.put("requestor", requestor);
	        variables.put("treatName", treatName);
	        runtimeService.startProcessInstanceByKey("treatRequestReview", variables);
	        
	
	        TaskService taskService = processEngine.getTaskService();
	        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("parents").list();
	        System.out.println("You have " + tasks.size() + " tasks:");
	        for (int i=0; i<tasks.size(); i++) {
	          System.out.println((i+1) + ") " + tasks.get(i).getName());
	        }
	        
	        System.out.println("Which task would you like to complete?");
	        int taskIndex = Integer.valueOf(scanner.nextLine());
	        Task task = tasks.get(taskIndex - 1);
	        Map<String, Object> processVariables = taskService.getVariables(task.getId());
	        System.out.println(processVariables.get("requestor") + " wants " +
	            processVariables.get("treatName") + " as a treat. Do you approve this?");
	        
	        boolean approved = scanner.nextLine().toLowerCase().equals("y");
	        System.out.println(approved);
	        variables = new HashMap<String, Object>();
	        variables.put("approved", approved);
	        taskService.complete(task.getId(), variables);
	    }
	    finally {
	    	scanner.close();
	    }
	}
}
