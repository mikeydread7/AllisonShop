package com.allison.shop.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.allison.shop.product.jpa.ProductRepository;
import com.allison.shop.product.model.Product;

@Component
public class ShopProductItemListLoader implements CommandLineRunner {

	private final ProductRepository repository;

	@Autowired
	public ShopProductItemListLoader(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {

		this.repository.save(new Product(new Date(), new Date(), "+5 Dexterity Vest", "5DexterityVest", 10, 20));
		this.repository.save(new Product(new Date(), new Date(), "Aged Brie", "AgedBrie", 2, 0));
		this.repository.save(new Product(new Date(), new Date(), "Elixir of the Mongoose", "ElixirMongoose", 5, 7));
		this.repository.save(new Product(new Date(), new Date(), "Sulfuras", "Sulfuras", 0, 80));
		this.repository.save(new Product(new Date(), new Date(), "Concert backstage passes", "ConcertBackstagePass", 15, 20));

	}
}