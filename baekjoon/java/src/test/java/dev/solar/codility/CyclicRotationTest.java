package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationTest {

    private static CyclicRotation cyclicRotation;

    @BeforeEach
    void setUp() {
        cyclicRotation = new CyclicRotation();
    }

    @Test
    void test1() {
        int[] arr = {3, 8, 9, 7, 6};
        int K = 3;
        int[] actual = cyclicRotation.solution(arr, K);
        System.out.println(Arrays.toString(actual));
        int[] expected = {9, 7, 6, 3, 8};
        assertArrayEquals(expected, actual);
    }
}
