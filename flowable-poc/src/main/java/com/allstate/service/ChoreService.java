/**
 * 
 */
package com.allstate.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jayasreeveliyath
 *
 */
public class ChoreService implements JavaDelegate {
	
	private static Logger log = LoggerFactory.getLogger(ChoreService.class);

    public void execute(DelegateExecution execution) {
    	log.info("Boo!! Chore! for id: {}!", execution.getId());

    }

}