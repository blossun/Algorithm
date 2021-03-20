package dev.solar.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test2Test {
    private Test2 test2;

    @BeforeEach
    void setUp() {
        test2 = new Test2();
    }

    @Test
    void test1() {
        String str = "AaTa+!12-3";
        int[] expected = {2};
        assertArrayEquals(expected, test2.solution(str));
    }

    @Test
    void test2() {
        String str = "ZzZz9Z824";
        int[] expected = {0};
        assertArrayEquals(expected, test2.solution(str));
    }

    @Test
    void test3() {
        String str = "CaCbCgCdC888834A";
        int[] expected = {1, 4, 5};
        assertArrayEquals(expected, test2.solution(str));
    }

    @Test
    void test4() {
        String str = "-----";
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, test2.solution(str));
    }
}
