package dev.solar.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    void test2() {
        int[] array = {5, 6, 3};
        int[] ints = Arrays.copyOfRange(array, 0, 3);
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
