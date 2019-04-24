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
}
