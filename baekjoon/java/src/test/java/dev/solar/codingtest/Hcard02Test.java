package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Hcard02Test {
    Hcard02 hcard02 = new Hcard02();

    @Test
    void case01() {
        int k = 3;
        int m = 2;
        assertEquals(2, hcard02.solution(k, m));
    }
}
