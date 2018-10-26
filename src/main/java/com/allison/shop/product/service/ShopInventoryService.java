package com.allison.shop.product.service;

import java.util.List;

import com.allison.shop.product.model.Product;

public interface ShopInventoryService {
    /**
     * @description Get All items
     * 
     * @return
     */
	List<Product> getALLItemsInShop();
    /**
     * @description Get All items and its quality after ${x} days
     * 
     * @param day
     * @return
     */
	List<Product> getCurrentItemListInShop(Integer day);
	
	/**
	 * @description Get All items quality
	 * 
	 * @param quality
	 * @return
	 */
	List<Product> getCurrentItemListByQualityInShop(Integer quality);
	
	/**
	 * @description Get item by its shortname
	 * 
	 * @return
	 */
	Product getItemByShortNameInventory( String  shortName);

}
