package com.allison.shop.product.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.allison.shop.app.ShopInventoryApplicationTest;
import com.allison.shop.product.model.Product;
import com.allison.shop.product.service.ShopInventoryService;


@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.DEFAULT)
public class ShopInventoryItemsRestControllerTest extends ShopInventoryApplicationTest {

	@Mock
	private HttpServletRequest mockHttpServletRequest;
	@Mock
	private ShopInventoryService shopInventoryService;

	@InjectMocks
	private ShopInventoryItemsRestController shopInventorController;

	@Before
	public void setup() {
		HttpServletRequest mockRequest = new MockHttpServletRequest();
		ServletRequestAttributes servletRequestAttributes = new ServletRequestAttributes(
				mockRequest);
		RequestContextHolder.setRequestAttributes(servletRequestAttributes);
	}

	@After
	public void teardown() {
		RequestContextHolder.resetRequestAttributes();
	}

	@Test
	public void testShopInventoryController() {
		assertNotNull(mockHttpServletRequest);
		assertNotNull(shopInventoryService);
		assertNotNull(shopInventorController);
	}

	@Test
	public void testGetAllInventory() {
		when(mockHttpServletRequest.getAttribute(anyString())).thenReturn("/");
		when((shopInventoryService.getALLItemsInShop()))
				.thenReturn(MOCK_PRODUCT_ITEM_LIST);
		ResponseEntity<?> results = shopInventorController.getAllInventory();
		assertTrue("Found values", ((List<Product>) results.getBody()).size() == 5);
		assertEquals(HttpStatus.OK, results.getStatusCode());
	}

	@Test
	public void testGetItemByShortNameInventory() {
		String shortName = "5DexterityVest";
		String shortNameEndPoint = "/shortname/".concat(shortName);
		when(mockHttpServletRequest.getAttribute(anyString()))
				.thenReturn(shortNameEndPoint);
		when((shopInventoryService.getItemByShortNameInventory(shortName)))
				.thenReturn(MOCK_PRODUCT_ITEM_LIST.get(0));
		ResponseEntity<?> results = shopInventorController
				.getItemByShortNameInventory(shortName);
		assertTrue("Found ",
				((Product) results.getBody()).getShortName().equals(shortName));
		assertTrue("Found ", ((Product) results.getBody()).getQuality().equals(20));
		assertEquals(HttpStatus.OK, results.getStatusCode());
	}

	@Test
	public void testGetAllCurrentIntemInShopFutureValueInventory() {
		Integer dayOffset = 100;
		String futureDayOffsetEndPoint = "/future/day/".concat(dayOffset.toString());
		when(mockHttpServletRequest.getAttribute(anyString()))
				.thenReturn(futureDayOffsetEndPoint);
		when((shopInventoryService.getCurrentItemListInShop(dayOffset)))
				.thenReturn(MOCK_PRODUCT_ITEM_LIST_OFFSET_50_DAYS);
		ResponseEntity<?> results = shopInventorController
				.getAllCurrentItemInShopFutureValueInventory(dayOffset);
		assertTrue("Found ", ((List<Product>) results.getBody()).get(1).getShortName()
				.equals("AgedBrie"));
		assertTrue("Found ",
				((List<Product>) results.getBody()).get(1).getQuality().equals(50));
		assertEquals(HttpStatus.OK, results.getStatusCode());
	}

	@Test
	public void testGetAllInventoryByQuality() {
		Integer quality = 7;
		String qualityEndPoint = "/quality/".concat(quality.toString());
		when(mockHttpServletRequest.getAttribute(anyString()))
				.thenReturn(qualityEndPoint);
		when((shopInventoryService.getCurrentItemListByQualityInShop(quality)))
				.thenReturn(getQulitArrayListwithSeven(quality));
		ResponseEntity<?> results = shopInventorController
				.getAllInventoryByQuality(quality);
		if (((List<Product>) results.getBody()).size() == 1) {
			assertTrue("Found ", ((List<Product>) results.getBody()).size() == 1);
			assertTrue(((List<Product>) results.getBody()).get(0).getQuality()
					.equals(quality));
		}
		assertEquals(HttpStatus.OK, results.getStatusCode());

	}

	// *************************************************************************************************
	// Utility

	private static List<Product> getQulitArrayListwithSeven(Integer quality) {
		return (MOCK_PRODUCT_ITEM_LIST.stream()
				.filter(p -> p.getQuality().equals(quality))).collect(Collectors.toList());

	}

}
