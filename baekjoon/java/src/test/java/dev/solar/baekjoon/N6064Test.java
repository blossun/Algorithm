package dev.solar.baekjoon;

import org.junit.jupiter.api.Test;

import static dev.solar.baekjoon.N6064.solution;
import static org.junit.jupiter.api.Assertions.*;

class N6064Test {

    @Test
    void case01() {
        int expected = 33;
        int actual = solution(10, 12, 3, 9);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int expected = -1;
        int actual = solution(10, 12, 7, 2);
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        int expected = 83;
        int actual = solution(13, 11, 5, 6);
        assertEquals(expected, actual);
    }
}
