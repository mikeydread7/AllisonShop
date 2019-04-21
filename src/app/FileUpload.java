/**
 * The purpose of this  Class
 */
package com.allison.shop.app;

/**
 * @author MichaelDev
 *
 */
public class FileUpload {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		BatchSchedular collectionbatchSchedular = new CollectionSchedular();
		BatchSchedular reversalbatchSchedular = new ReversalSchedular();
		BatchSchedular achPaymentsVendor = new ACHPaymentsSchedular(ACHBatchType.VENDOR);
		BatchSchedular achPaymentsPayroll = new ACHPaymentsSchedular(ACHBatchType.PAYROLL);
		DoStuff(reversalbatchSchedular);
		DoStuff(collectionbatchSchedular);
		DoStuff(achPaymentsVendor);
		DoStuff(achPaymentsPayroll);
	}

	/**
	 * @param batchSchedular
	 */
	private static void DoStuff(BatchSchedular batchSchedular) {
		ACHSchedularEntity achSchedularEntity = new ACHSchedularEntity(batchSchedular.achBatchType, "upLoad it");
		batchSchedular.schedule("5000", achSchedularEntity);	
	}

}
