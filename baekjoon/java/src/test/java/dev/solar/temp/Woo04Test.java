package dev.solar.temp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Woo04Test {
    Woo04 woo04 = new Woo04();

    @Test
    void case01() {
        int[] pobi = {97, 98};
        int[] crong = {197, 198};
        int expected = 0;
        int actual = woo04.solution(pobi, crong);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] pobi = {131, 132};
        int[] crong = {211, 212};
        int expected = 1;
        int actual = woo04.solution(pobi, crong);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int[] pobi = {99, 102};
        int[] crong = {197, 198};
        int expected = -1;
        int actual = woo04.solution(pobi, crong);
        assertEquals(expected, actual);
    }
}
