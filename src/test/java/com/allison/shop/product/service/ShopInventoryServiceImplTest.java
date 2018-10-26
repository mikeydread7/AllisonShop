package com.allison.shop.product.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.allison.shop.app.ShopInventoryApplicationTest;
import com.allison.shop.product.model.Product;

public class ShopInventoryServiceImplTest  extends  ShopInventoryApplicationTest{

	@Mock
	private ShopInventoryService shopInventoryService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
    public void testMockCreation(){
        assertNotNull(shopInventoryService);
    }
	
    
	@Test
	public void testGetALLItemsInShop() {
    	when(shopInventoryService.getALLItemsInShop()).thenReturn(MOCK_PRODUCT_ITEM_LIST);
		assertTrue(shopInventoryService.getALLItemsInShop().size() > 1);
		verify(shopInventoryService, times(1)).getALLItemsInShop();
	}
	
    
	@Test
	public void testGetCurrentItemListInShop() {
    	Integer daysOffset = 100;
    	when(shopInventoryService.getCurrentItemListInShop(daysOffset)).thenReturn(MOCK_PRODUCT_ITEM_LIST_OFFSET_50_DAYS);
		assertTrue(shopInventoryService.getCurrentItemListInShop(daysOffset).get(3).getQuality().equals(80));
		verify(shopInventoryService, times(1)).getCurrentItemListInShop(daysOffset);
	}
    
	@Test
	public void testGetItemByShortNameInventory() {
    	String shortName = "ElixirMongoose";
    	when(shopInventoryService.getItemByShortNameInventory(shortName)).thenReturn(MOCK_PRODUCT_ITEM_LIST.get(2));
		assertTrue(shopInventoryService.getItemByShortNameInventory(shortName).getQuality().equals(7));
		verify(shopInventoryService, times(1)).getItemByShortNameInventory(shortName);
	}
    
	@Test
	public void testGetAllItemByQualityInventory() {
    	
    	Integer quality = 20;
    	when(shopInventoryService.getCurrentItemListByQualityInShop(quality)).thenReturn(getQualitOfTwenty(quality));
    	assertTrue(shopInventoryService.getCurrentItemListByQualityInShop(quality).size() == 2);
		verify(shopInventoryService, times(1)).getCurrentItemListByQualityInShop(quality);
	}

	// *************************************************************************************************
	// Utility

	private List<Product> getQualitOfTwenty(Integer quality) {
		return MOCK_PRODUCT_ITEM_LIST.stream()
							.filter(p->p.getQuality().equals(quality))
							.collect(Collectors.toList());
		
	}

}