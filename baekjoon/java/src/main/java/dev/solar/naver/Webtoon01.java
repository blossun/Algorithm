package dev.solar.naver;

import java.util.Arrays;

public class Webtoon01 {
    public int solution(int[] prices, int[] discounts) {
        // 큰가격에 큰 할인율을 적용하면 된다.
        // discounts는 우선순위큐로 할인율이 큰 순서대로
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int total = 0;
        int useDiscount = discounts.length - 1;
        for (int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            if (useDiscount >= 0) {
                int discountPrice = (price * (100 - discounts[useDiscount--])) / 100;
                total += discountPrice;
                System.out.println("price : " + price +", discounted : " + discountPrice);
            } else {
                total += price;
            }
        }
        return total;
    }
}
