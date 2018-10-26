package com.allison.shop.product.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allison.shop.product.jpa.ProductRepository;
import com.allison.shop.product.model.Product;

@Service
public class ShopInventoryServiceImpl implements ShopInventoryService {
	
	public  ShopInventoryServiceImpl(){
		
	}
	@Autowired
	private ProductRepository productRepository;

	private static final List<String> SPECIAL_ITEM_LIST = Arrays.asList("AgedBrie",
			"Sulfuras", "ConcertBackstagePass");

	
    /**
     * @description call the use java8 to Intstream to track the day to day values
     * @param product
     * @param day
     * @return
     */
	private static Product updateEachItemQuality(final Product product, final Integer day) {

		IntStream.range(0, day)
				.parallel()
				// The quality of an item is never negative
				.forEach(i -> endOfDayInventoryTracking(product));
		return product;
	}

	/**
	 * At the end of each day, quality decrements by 1 At the end of each day,
	 * sellIn decrements by 1 Once the sell by date has passed, quality degrades
	 * twice as fast The quality of an item is never more than 50
	 * 
	 * @param updateProduct
	 */
	private static void endOfDayInventoryTracking(Product updateProduct) {
		
        updateFutureDate(updateProduct);
		if (SPECIAL_ITEM_LIST.contains(updateProduct.getShortName())) {
			updateProduct	= handleSpecialItems(updateProduct);
		} else {
			updateProduct = handleRemainingProductsItems(updateProduct);
		}
	}

	/**
	 * @description Just for tracking the offset date and metrics
	 * 
	 * @param updateProduct
	 */
	private static void updateFutureDate(final Product updateProduct) {
		Date currentDate = new Date();
        // convert date to LocalDateTime
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        // plus one
        localDateTime = localDateTime.plusDays(1);
        // convert LocalDateTime to date
        Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        updateProduct.setFutureDate(currentDatePlusOneDay);
	}

	/**
	 * @description handle special remaining items
	 * At the end of each day, quality decrements by 1
     * At the end of each day, sellIn decrements by 1
	 * Once the sell by date has passed, quality degrades twice as fast
	 * The quality of an item is never negative
	 * 
	 * @param updateProduct
	 */
	private static Product handleRemainingProductsItems(final Product updateProduct) {
		
		updateProduct.setSellIn(updateProduct.getSellIn() - 1);
		//The quality of an item is never negative
		if (updateProduct.getQuality() > 0) {
			//At the end of each day, quality decrements by 1
			endOfEachDayQualityDegregationStatus(updateProduct);     
			      
		}          
		
		return updateProduct;
	}
	
    /**
     * @description Once the sell by date has passed, quality degrades, so calculate it
     * 
     * @param updateProduct
     */
	private static void endOfEachDayQualityDegregationStatus(final Product updateProduct) {
		if (updateProduct.getSellIn() >= 0) {
			updateProduct.setQuality(updateProduct.getQuality() - 1);
		}else{ 
			if (updateProduct.getQuality() >= 2) {
				//Once the sell by date has passed, quality degrades twice as fast
				updateProduct.setQuality(updateProduct.getQuality() - 2);
			}else{
				updateProduct.setQuality(updateProduct.getQuality() - 1);
			} 
		}
	}
	
    /**
     * @description edge cases handle special Items
     *  Some types of items in our shop deviate from the normal deprecation rules:
     *  1. Aged Brie Quality increments by 1 as the sell by date approaches
     *  2. Sulfuras Never has to be sold and never decreases in quality
	 *  3. Concert backstage  passes
	 *	   quality increments by 1 as the sell by date approaches
	 *	   and increments by 2 when there are 10 days or less; the
	 *	   quality drops to 0 after the sell by date
	 *
     * @param specialProduct    
     */                     
	private static Product handleSpecialItems(final Product specialProduct) {

		switch (specialProduct.getShortName()) {    
			case "AgedBrie":
				specialProduct.setSellIn(specialProduct.getSellIn() - 1);
				//assumption 1 "approaches" 0 and will continue to increase in quality and not go-over 50
				specialProduct.setQuality(handleItemsQualityThatIncreases(specialProduct.getQuality() + 1));
				break;
			case "ConcertBackstagePass":
				specialProduct.setSellIn(specialProduct.getSellIn() - 1);
				if (specialProduct.getSellIn() < 0) {
					specialProduct.setQuality(0);
				} else if (specialProduct.getSellIn() <= 10) {
					specialProduct.setQuality(handleItemsQualityThatIncreases(specialProduct.getQuality() + 2));
				} else {
					specialProduct.setQuality(handleItemsQualityThatIncreases(specialProduct.getQuality() + 1));
				}
				
				break;
			case "Sulfuras": // Never has to be sold and never decreases in quality..assumes is never changes 
				break;       // product owner and BA need to validate
		}
		return specialProduct;
	}
   
	/**
	 *  
     * @description edge cases handle special Items that increase in quality
	 * The quality of an item is never more than 50
	 * 
	 * @param quality
	 * @return
	 */
	private static Integer handleItemsQualityThatIncreases(Integer quality){
		Integer results = 50;
	    if(quality <= results){
		   results = quality;
	    }
	    return results;
	}

	public List<Product> getALLItemsInShop() {

		return (List<Product>) productRepository.findAll();
	}

	public List<Product> getCurrentItemListInShop(Integer day) {
		List<Product> prodList = (List<Product>) this.getALLItemsInShop();

		return prodList.stream()
				.parallel()
				.map(product -> updateEachItemQuality(product, day))
				.collect(Collectors.toList());

	}
	
	public Product getItemByShortNameInventory(String shortName) {
		
		return productRepository.findByShortName(shortName);
	}

	public List<Product> getCurrentItemListByQualityInShop(Integer quality) {
		
		return productRepository.findByQuality(quality);
	}
}
