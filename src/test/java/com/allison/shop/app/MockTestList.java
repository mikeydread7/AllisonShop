package com.allison.shop.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.allison.shop.product.model.Product;

@SuppressWarnings("serial")
public interface MockTestList {

	final List<Product> MOCK_PRODUCT_ITEM_LIST = new ArrayList<Product>() {
		{
			add(new Product(new Date(1L),new Date(1L),"+5 Dexterity Vest","5DexterityVest", 10, 20));
			add(new Product(new Date(1L),new Date(1L),"Aged Brie", "AgedBrie",2, 0));
			add(new Product(new Date(1L),new Date(1L),"Elixir of the Mongoose","ElixirMongoose" ,5, 7));
			add(new Product(new Date(1L),new Date(1L), "Sulfuras","Sulfuras", 0, 80));
			add(new Product(new Date(1L),new Date(1L),"Concert backstage passes","ConcertBackstagePass", 15, 20));
		}
	};
	/**
	 * assumption is included
	 * Edge cases                      	          in 51 days
	 * -----------------------------------------------------
	 * +5 Dexterity Vest      10 20				0
	 * Elixir of the Mongoose  5  7				0
	 * ------------------------------------------------------
	 * Aged Brie 2 0            0+50			50 //The quality of an item is never more than 50          
	 * Sulfuras 0 80					80
	 * Concert backstage pass  ==>20+5+(2*10)		0
	 * 
	 */
 
	final List<Product> MOCK_PRODUCT_ITEM_LIST_OFFSET_50_DAYS = new ArrayList<Product>() {
		{
			add(new Product(new Date(1L),new Date(50L),"+5 Dexterity Vest","5DexterityVest", -40, 0));
			add(new Product(new Date(1L),new Date(50L),"Aged Brie", "AgedBrie",-48, 50));
			add(new Product(new Date(1L),new Date(50L),"Elixir of the Mongoose","ElixirMongoose" ,-45, 0));
			add(new Product(new Date(1L),new Date(50L), "Sulfuras","Sulfuras", 0, 80));
			add(new Product(new Date(1L),new Date(50L),"Concert backstage passes","ConcertBackstagePass", -35, 0));
		}
	};
	
		
	
}