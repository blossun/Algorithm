package dev.solar.naver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Webtoon01Test {

    Webtoon01 webtoon01 = new Webtoon01();

    @Test
    void case01() {
        int[] prices = {13000, 88000, 10000};
        int[] discounts = {30, 20};
        int expected = 82000;
        int actual = webtoon01.solution(prices, discounts);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] prices = {13000, 88000, 10000};
        int[] discounts = {};
        int expected = Arrays.stream(prices).sum();
        int actual = webtoon01.solution(prices, discounts);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int[] prices = {32000, 18000, 42500};
        int[] discounts = {50, 20, 65};
        int expected = 45275;
        int actual = webtoon01.solution(prices, discounts);
        assertEquals(expected, actual);
    }

    @Test
    void case04() {
        int[] prices = {32000, 18000, 42500};
        int[] discounts = {100, 100, 100};
        int expected = 0;
        int actual = webtoon01.solution(prices, discounts);
        assertEquals(expected, actual);
    }
}
