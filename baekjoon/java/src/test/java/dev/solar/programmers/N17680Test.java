package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N17680Test {

    N17680 n17680 = new N17680();

    @Test
    void case01() {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int actual = n17680.solution(cacheSize, cities);
        assertEquals(50, actual);
    }

    @Test
    void case02() {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int actual = n17680.solution(cacheSize, cities);
        assertEquals(16, actual);
    }

    @Test
    void case03() {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int actual = n17680.solution(cacheSize, cities);
        assertEquals(20, actual);
    }
}
