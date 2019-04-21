/**
 * The purpose of this  Class
 */
package com.allison.shop.app;

/**
 * @author MichaelDev
 *
 */
public  abstract class BatchSchedular {
   public ACHBatchType  achBatchType;
   public  BatchSchedular( ACHBatchType  achBatchType ) {
	   this.achBatchType = achBatchType;
   }
   protected void schedule( String  fileId, ACHSchedularEntity achSchedularEntity) {
	   achSchedularEntity.sheduleCurrentBatchInQueue(fileId);
   }
}
