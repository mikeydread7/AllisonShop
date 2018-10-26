package com.allison.shop.product.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.allison.shop.product.model.Product;

@Transactional
@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Product findByItem(@Param("itemName") String itemName);
	Product findByShortName(@Param("shortName") String shortName);
	List<Product> findByQuality(@Param("quality") Integer quality);
	
	//Order BY JPLQ
	List<Product>findByQualityOrderByShortNameAsc(@Param("quality") Integer quality);
	/*
	 * The search function of our example application returns Product entries whose item or 
	 * shortName contains the given search term. If we want to sort the search results
	 * in ascending order by using the value of the shortName field, we have to add the following query
 	 * method into our repository interface:
	 */
	 List<Product> findByShortNameContainsOrItemContainsAllIgnoreCaseOrderByShortNameAsc(
			 @Param("itemName") String itemName,
			 @Param("shortName") String shortName);
	
	 /**
	  * Custom query
	  */
	 @Query ("SELECT p FROM Product p WHERE p.sellIn = :sellIn ORDER BY p.shortName DESC")
	 List<Product>findBySellInOrderByShortNameAsc(@Param("sellIn") Integer sellIn);
	 
	 
	 /*@Query (value="SELECT * FROM Product p WHERE p.sellIn = :sellIn ORDER BY p.shortName DESC" ,
			 nativeQuery = true)
	 List<Product>findBySellInOrderByShortNameAscNativeQuery(@Param("sellIn") Integer sellIn);*/
	
	
}
