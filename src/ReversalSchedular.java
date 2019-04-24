/**
 * The purpose of this  Class
 */
package com.allison.shop.app;

/**
 * @author MichaelDev
 *
 */
public class ReversalSchedular extends BatchSchedular {
	public ReversalSchedular() {
		super(ACHBatchType.REVERSAL);
	}
	public void sheduleCurrentBatchInQueue(final ACHSchedularEntity achSchedularEntity) {
		logger.info("{}: schedule entity properties {}",this.achBatchType, achSchedularEntity.getProfileId());
        }
}
