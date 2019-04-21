package com.allison.shop.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Data
@ActiveProfiles("h2")
@RunWith(SpringJUnit4ClassRunner.class)
public class ShopInventoryApplicationTest implements MockTestList {

    private final Logger logger = LoggerFactory.getLogger(ShopInventoryApplicationTest.class);

    //utility
    private static String callThisMethod(Integer number) {
        return Integer.toBinaryString(number);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testArrayIsGrowable() {
        List<String> stringList = new ArrayList<String>();

        IntStream
                .range(0, 6)
                .forEach(i -> stringList.add(callThisMethod(i)));

    }

    @Test
    public void testNumberInList() {
        List<Integer> arr = new ArrayList<Integer>();

        //numbers is found  in the list
        int k = 20;
        boolean b = arr.stream()
                .filter(i -> i == k)
                .findFirst()
                .isPresent();
        String anws = (b) ? "YES" : "NO";
        logger.info("anws: {}", anws);


    }

    @Test
    public void testOddNumberInBetweenRange() {
        //odd number in between
        int l = 3;
        int r = 9;
        List<Integer> IntegerList2 =
                IntStream.rangeClosed(l, r)
                        .filter(i -> i % 2 != 0)
                        .boxed()
                        .collect(Collectors.toList());
        logger.info("IntegerList2: {}", IntegerList2);

    }

    @Test
    public void testIsPrimeNumber() {

        int number = 21;
        boolean isPrime;
        String anwsp;
		/*isPrime = IntStream.rangeClosed(2, (int) Math.sqrt(new Double(number)))
				 .allMatch(i->number % i != 0);
		anwsp = (isPrime )? "YES":"NO";*/

        IntPredicate isDivisible = index -> number % index == 0;
        isPrime = number > 1 && IntStream.range(2, number - 1).noneMatch(isDivisible);
        anwsp = (isPrime) ? "YES" : "NO";
        logger.info("{} is prime : {}", number, anwsp);

        List<Integer> ints = IntStream.of(1, 2, 3, 4, 5)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        logger.info("list--> {} ", ints);
    }


}
/*
public static void main(String[] args) throws IOException{
Scanner input = new Scanner(System.in);
List<String> preferredCategories = Arrays.asList(input.nextLine().split(","));
List<Map<String, Object>> coupons = new ArrayList<>();
int lines = Integer.parseInt(input.nextLine());
IntStream.range(0, lines).forEach(i -> coupons.add(readCoupon(input)));
List<Map<String, Object>> personalizedCoupons = personalizeCoupons(coupons, preferredCategories);
personalizedCoupons.stream().forEach(PersonalizedCoupons::printCoupon);
}

public static Map<String, Object> readCoupon(Scanner input) {
String[] couponItems = input.nextLine().split(",");
Map<String,Object> coupon = new HashMap<>();
coupon.put("upc", couponItems[0]);
coupon.put("code", couponItems[1]);
coupon.put("category", couponItems[2]);
coupon.put("itemPrice", Float.parseFloat(couponItems[3]));
coupon.put("couponAmount", Float.parseFloat(couponItems[4]));
return coupon;
}

public static void printCoupon(Map<String, Object> coupon)
{
System.out.print("{");
System.out.print("\"couponAmount\":" +  coupon.get("couponAmount") + ",");
System.out.print("\"upc\":\"" +  coupon.get("upc") + "\",");
if(coupon.containsKey("code")) {
    System.out.print("\"code\":\"" +  coupon.get("code") + "\",");
}
System.out.print("\"itemPrice\":" +  coupon.get("itemPrice") + ",");
System.out.println("\"category\":\"" +  coupon.get("category") + "\"}");
}
}*/