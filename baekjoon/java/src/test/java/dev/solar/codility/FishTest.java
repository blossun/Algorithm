package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FishTest {
    private Fish fish;

    @BeforeEach
    void setUp() {
        fish = new Fish();
    }

    @Test
    void test1() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};
        int actual = fish.solution(A, B);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 0, 0, 0, 0};
        int actual = fish.solution(A, B);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {1, 0, 0, 0, 0};
        int actual = fish.solution(A, B);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[] A = {4, 6, 3, 2, 1, 5, 2};
        int[] B = {0, 1, 1, 0, 0, 0, 0};
        int actual = fish.solution(A, B);
        int expected = 2;
        assertEquals(expected, actual);
    }
}
