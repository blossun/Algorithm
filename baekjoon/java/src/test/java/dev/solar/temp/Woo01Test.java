package dev.solar.temp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Woo01Test {
    Woo01 woo01 = new Woo01();

    @Test
    void case01() {
        int money = 50237;
        int[] expected = {1, 0, 0, 0, 0, 2, 0, 3, 7};
        int[] actual = woo01.solution(money);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case02() {
        int money = 15000;
        int[] expected = {0, 1, 1, 0, 0, 0, 0, 0, 0};
        int[] actual = woo01.solution(money);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case03() {
        int money = 150000;
        int[] expected = {3, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] actual = woo01.solution(money);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case04() {
        int money = 0;
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] actual = woo01.solution(money);
        assertArrayEquals(expected, actual);
    }
}
