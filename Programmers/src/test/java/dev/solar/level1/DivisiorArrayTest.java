package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisiorArrayTest {
    DivisiorArray divisiorArray = new DivisiorArray();

    @Test
    void test1() {
        int[] expected = {5, 10};
        int[] actual = divisiorArray.solution(new int[]{5, 9, 7, 10}, 5);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] expected = {1, 2, 3, 36};
        int[] actual = divisiorArray.solution(new int[]{2, 36, 1, 3}, 1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] expected = {-1};
        int[] actual = divisiorArray.solution(new int[]{3, 2, 6}, 10);
        assertArrayEquals(expected, actual);
    }
}
