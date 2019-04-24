/**
 * The purpose of this  Class
 */
package com.allison.shop.app;

/**
 * @author MichaelDev
 *
 */
public class FileUploadClientSimulator {

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
	private static void DoStuff(final BatchSchedular batchSchedular) {
	
		ACHSchedularEntity achSchedularEntity = 
				new ACHSchedularEntity(batchSchedular.achBatchType, 2000L, 3000L, 400L);

		switch (batchSchedular.achBatchType) {
		case COLLECTION:
			batchSchedular.schedule(achSchedularEntity);
			break;
		case VENDOR:
		case PAYROLL:
			batchSchedular.schedule( achSchedularEntity);
			break;
		case REVERSAL:
			batchSchedular.schedule(achSchedularEntity);
			break;
		default:
			break;
		}
	}
}
