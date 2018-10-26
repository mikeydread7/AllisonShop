package com.allison.shop.product.rest;

import static com.allison.shop.product.utils.UtilConstants.API_VERSION;
import static com.allison.shop.product.utils.UtilConstants.SHOP_API_ENDPOINT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allison.shop.product.service.ShopInventoryService;

@RestController
@RequestMapping(SHOP_API_ENDPOINT)
public class ShopInventoryItemsRestController {

	// *************************************************************************************************
	// Constants
	private final Logger logger = LoggerFactory.getLogger(ShopInventoryItemsRestController.class);

	// *************************************************************************
	// member variables
	private ShopInventoryService shopInventoryService;

	// *************************************************************************
	// Constructors
	public ShopInventoryItemsRestController(ShopInventoryService shopInventoryService) {
		this.shopInventoryService = shopInventoryService;
	}

	// *************************************************************************
	// Implementations
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ API_VERSION)
	public ResponseEntity<?> getAllInventory() {
		logger.info("get all product Items in the shop");
		return new ResponseEntity<>(shopInventoryService.getALLItemsInShop(),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/shortname/{shortName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ API_VERSION)
	public ResponseEntity<?> getItemByShortNameInventory(@PathVariable String shortName) {
		logger.info("get all product Items by short Name");

		return new ResponseEntity<>(
				shopInventoryService.getItemByShortNameInventory(shortName),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/future/day/{dayOffset}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ API_VERSION)
	public ResponseEntity<?> getAllCurrentItemInShopFutureValueInventory(
			@PathVariable Integer dayOffset) {
		logger.info("get all product Items base on day(s) in the future");

		return new ResponseEntity<>(
				shopInventoryService.getCurrentItemListInShop(dayOffset), HttpStatus.OK);

	}

	@RequestMapping(value = "/quality/{quality}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ API_VERSION)
	public ResponseEntity<?> getAllInventoryByQuality(@PathVariable Integer quality) {
		logger.info("get all product Items by quality");
		return new ResponseEntity<>(
				shopInventoryService.getCurrentItemListByQualityInShop(quality),
				HttpStatus.OK);
	}

}
