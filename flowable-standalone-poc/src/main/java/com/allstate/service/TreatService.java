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
public class TreatService implements JavaDelegate {
	
	private static Logger log = LoggerFactory.getLogger(TreatService.class);
	
    public void execute(DelegateExecution execution) {
    	log.info("Woo!! Offered money for id: {}!", execution.getId());
    }
}