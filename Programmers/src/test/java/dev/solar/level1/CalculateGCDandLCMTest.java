package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateGCDandLCMTest {
    CalculateGCDandLCM calculateGCDandLCM = new CalculateGCDandLCM();

    @Test
    void test1() {
        int[] expected = {3, 12};
        int[] actual = calculateGCDandLCM.solution(3, 12);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] expected = {1, 10};
        int[] actual = calculateGCDandLCM.solution(2, 5);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] expected = {6, 12}; // 1 2 (3,6) 3 , 1,2
        int[] actual = calculateGCDandLCM.solution(6, 12);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test4() {
        int[] expected = {12, 24}; // 2 (6,12) 2 (3,6) 3 , 1, 2
        int[] actual = calculateGCDandLCM.solution(12, 24);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test5() {
        int[] expected = {7,84 };
        int[] actual = calculateGCDandLCM.solution(28, 21);
        assertArrayEquals(expected, actual);
    }
}
