package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TapeEquilibriumTest {

    private static TapeEquilibrium tapeEquilibrium;

    @BeforeEach
    void setUp() {
        tapeEquilibrium = new TapeEquilibrium();
    }

    @Test
    void test1() {
        int[] arr = {3, 1, 2, 4, 3};
        int actual = tapeEquilibrium.solution(arr);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] arr = {1, 1};
        int actual = tapeEquilibrium.solution(arr);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] arr = {-1000, 1000};
        int actual = tapeEquilibrium.solution(arr);
        int expected = 2000;
        assertEquals(expected, actual);
    }
}
