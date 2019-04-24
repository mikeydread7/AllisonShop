package com.allison.shop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MichaelDev
 *
 */
public class ReversalSchedular extends BatchSchedular {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public ReversalSchedular() {
		super(ACHBatchType.REVERSAL);
	}
	public void sheduleCurrentBatchInQueue(final ACHSchedularEntity achSchedularEntity) {
		logger.info("{}: Exception to the norms {}",this.achBatchType, achSchedularEntity.getProfileId());
        }
}
