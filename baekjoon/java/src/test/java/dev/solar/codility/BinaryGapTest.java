package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    private static BinaryGap binaryGap;

    @BeforeEach
    void setUp() {
        binaryGap = new BinaryGap();
    }

    @Test
    void test1() {
        int actual = binaryGap.solution(9);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int actual = binaryGap.solution(529);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int actual = binaryGap.solution(20);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int actual = binaryGap.solution(32);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        int actual = binaryGap.solution(1041);
        int expected = 5;
        assertEquals(expected, actual);
    }
}
