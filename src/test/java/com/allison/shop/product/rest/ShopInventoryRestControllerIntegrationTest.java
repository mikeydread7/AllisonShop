package com.allison.shop.product.rest;

import static com.allison.shop.product.utils.UtilConstants.SHOP_API_ENDPOINT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.allison.shop.ShopInventoryApplication;
import com.allison.shop.app.ShopInventoryApplicationTest;
import com.allison.shop.product.service.ShopInventoryService;

@SpringBootTest(classes = ShopInventoryApplication.class)
public class ShopInventoryRestControllerIntegrationTest extends ShopInventoryApplicationTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Mock
	private ShopInventoryService shopInventoryService;

	@InjectMocks
	private ShopInventoryItemsRestController shopInventoryController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAllProductItems() throws Exception {

		assertThat(this.shopInventoryService).isNotNull();
		mockMvc.perform(get(SHOP_API_ENDPOINT).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testAllCurrentItemInShopFutureValueInventory() throws Exception {
		Integer futureDayOffset = 180;

		assertThat(this.shopInventoryService).isNotNull();
		mockMvc.perform(get(SHOP_API_ENDPOINT.concat("/future/day/")
				.concat(futureDayOffset.toString())).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[3].shortName", is("Sulfuras")))
				.andExpect(jsonPath("$.[3].quality", is(80))).andDo(print());
	}

	@Test
	public void testItemInShopShortName() throws Exception {
		String shortName = "Sulfuras";

		assertThat(this.shopInventoryService).isNotNull();
		mockMvc.perform(get(SHOP_API_ENDPOINT.concat("/shortname/").concat(shortName))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.quality", is(80))).andDo(print());
	}

	@Test
	public void testAProductItemQuality() throws Exception {
		Integer quality = 80;

		assertThat(this.shopInventoryService).isNotNull();
		mockMvc.perform(
				get(SHOP_API_ENDPOINT.concat("/quality/").concat(quality.toString()))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.[0].sellIn", is((0))))
				.andExpect(jsonPath("$.[0].quality", is(quality)))
				.andExpect(jsonPath("$.[0].item", is("Sulfuras")))
				.andExpect(jsonPath("$.[0].shortName", is("Sulfuras"))).andDo(print());
	}
}
