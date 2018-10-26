/**
 *  
 * 
 * @author Michael Somers, mike1somers@gmail.com
 *
 */
package com.allison.shop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShopInventoryApplication {
	private static final Logger logger = LoggerFactory.getLogger(ShopInventoryApplication.class);
	public static void main(String[] args) {
		logger.debug("Starting...");
		SpringApplication.run(ShopInventoryApplication.class, args);
		logger.debug("Success!");	
	}
}
