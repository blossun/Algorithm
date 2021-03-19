package dev.solar.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42584Test {
    private N42584 n42584;

    @BeforeEach
    void setUp() {
        n42584 = new N42584();
    }

    @Test
    void test1() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] expected = {4, 3, 1, 1, 0};
        assertArrayEquals(expected, n42584.solution(prices));
    }
}
