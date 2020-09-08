package dev.solar.baekjoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pibo10870sSolvTest {
    Pibo10870sSolv solv = new Pibo10870sSolv();

    @DisplayName("n = 10")
    @Test
    void test1() {
        int expected = 55;
        int actual = solv.pibo10870Solv(10);
        assertEquals(expected, actual);
    }

    @DisplayName("n = 1")
    @Test
    void test2() {
        int expected = 1;
        int actual = solv.pibo10870Solv(1);
        assertEquals(expected, actual);
    }

    @DisplayName("n = 13")
    @Test
    void test3() {
        int expected = 233;
        int actual = solv.pibo10870Solv(13);
        assertEquals(expected, actual);
    }

    @DisplayName("n = 17")
    @Test
    void test4() {
        int expected = 1597;
        int actual = solv.pibo10870Solv(17);
        assertEquals(expected, actual);
    }
}
