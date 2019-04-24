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
public abstract class BatchSchedular {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected final ACHBatchType achBatchType;

	public BatchSchedular(final ACHBatchType achBatchType) {
		this.achBatchType = achBatchType;
	}

	protected void schedule(final ACHSchedularEntity achSchedularEntity) {
		sheduleCurrentBatchInQueue(achSchedularEntity);
	}

	protected void sheduleCurrentBatchInQueue(final ACHSchedularEntity achSchedularEntity) {
		logger.info("{}: schedule entity properties {}",this.achBatchType, achSchedularEntity.toString());
	}
}
