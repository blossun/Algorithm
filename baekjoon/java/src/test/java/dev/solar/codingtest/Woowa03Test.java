package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Woowa03Test {
    Woowa03 woowa03 = new Woowa03();

    @Test
    void case01() {
        int[] A = {};
        int expected = 0;
        int actual = woowa03.solution(A);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] A = {1};
        int expected = 0;
        int actual = woowa03.solution(A);
        assertEquals(expected, actual);
    }


    @Test
    void case03() {
        int[] A = {1000000000, -1000000000};
        int expected = 1000000000;
        int actual = woowa03.solution(A);
        assertEquals(expected, actual);
    }


    @Test
    void case04() {
        int[] A = {1_000_000_000, 1_000_000_000};
        int expected = 0;
        int actual = woowa03.solution(A);
        assertEquals(expected, actual);
    }

}
