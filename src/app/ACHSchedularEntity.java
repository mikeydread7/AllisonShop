/**
 * The purpose of this  Class
 */
package com.allison.shop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MichaelDev
 *
 */

public class ACHSchedularEntity {
	final private String  uploadProfileId;
	final private ACHBatchType achBatachType;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * @param uploadProfileId
	 */
	public ACHSchedularEntity(final ACHBatchType achBatachType,final String uploadProfileId) {
		this.achBatachType = achBatachType;
		this.uploadProfileId = uploadProfileId;
	}
	
	public void sheduleCurrentBatchInQueue(String  fileId) {
		logger.info(" This is mine: {}",this.achBatachType);
		
		
	}
}
