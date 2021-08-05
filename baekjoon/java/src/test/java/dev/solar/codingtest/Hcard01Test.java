package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Hcard01Test {
    Hcard01 hcard01 = new Hcard01();

    @Test
    void case01() {
        String[] colors = {"RG", "WR", "BW", "GG"};
        int[] prices = {5000, 6000};
        assertEquals(21000, hcard01.solution(colors, prices));
    }

    @Test
    void case02() {
        String[] colors = {"BW", "RY", "BY"};
        int[] prices = {9000, 10000};
        assertEquals(30000, hcard01.solution(colors, prices));
    }
}
