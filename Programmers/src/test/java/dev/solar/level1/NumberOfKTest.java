package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfKTest {
    NumberOfK numberOfK = new NumberOfK();

    @Test
    void solution() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] expected = {5, 6, 3};
        int[] actual = numberOfK.solution(array, commands);
        assertArrayEquals(expected, actual);
    }
}