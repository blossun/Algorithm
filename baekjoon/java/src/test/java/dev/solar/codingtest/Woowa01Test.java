package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Woowa01Test {
    Woowa01 woowa01 = new Woowa01();

    @Test
    void case01() {
        int U = 2;
        int L = 3;
        int[] C = {0, 0, 1, 1, 2};
        String expected = "IMPOSSIBLE";
        String actual = woowa01.solution(U, L, C);
        assertEquals(expected, actual);
    }
}
