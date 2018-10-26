package com.allison.shop.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("h2")
@RunWith(SpringJUnit4ClassRunner.class)
public class ShopInventoryApplicationTest implements MockTestList {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testArrayIsGrowable(){
		 List <String>stringList = new ArrayList<String>();
		 
		 IntStream.range(0, 6).
		 forEach(i->stringList.add(callThisMethod(i)));
		 
	}
	
	
	private static String callThisMethod(Integer number) {
		return Integer.toBinaryString(number);
	}
	
	

	
}
