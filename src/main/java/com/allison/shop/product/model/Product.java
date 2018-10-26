package com.allison.shop.product.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name= "Product")
@Table(name= "Product")
public class Product {

    private @Id @GeneratedValue Long id;
    private Date    stockDate;
    private Date    futureDate;
	private String  item;
	private String  shortName;
    private Integer sellIn;
    private Integer quality;
    
    
	/**
	 * 
	 */
	public Product() {
	
	}


	/**
	 * @param stockDate
	 * @param futureDate
	 * @param item
	 * @param shortName
	 * @param sellIn
	 * @param quality
	 */
	public Product(Date stockDate, Date futureDate, String item, String shortName,
			Integer sellIn, Integer quality) {
		this.stockDate = stockDate;
		this.futureDate = futureDate;
		this.item = item;
		this.shortName = shortName;
		this.sellIn = sellIn;
		this.quality = quality;
	}


	/**
	 * @return the stockDate
	 */
	public Date getStockDate() {
		return stockDate;
	}


	/**
	 * @param stockDate the stockDate to set
	 */
	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}


	/**
	 * @return the futureDate
	 */
	public Date getFutureDate() {
		return futureDate;
	}


	/**
	 * @param futureDate the futureDate to set
	 */
	public void setFutureDate(Date futureDate) {
		this.futureDate = futureDate;
	}


	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}


	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}


	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}


	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	/**
	 * @return the sellIn
	 */
	public Integer getSellIn() {
		return sellIn;
	}


	/**
	 * @param sellIn the sellIn to set
	 */
	public void setSellIn(Integer sellIn) {
		this.sellIn = sellIn;
	}


	/**
	 * @return the quality
	 */
	public Integer getQuality() {
		return quality;
	}


	/**
	 * @param quality the quality to set
	 */
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	


	    
}

