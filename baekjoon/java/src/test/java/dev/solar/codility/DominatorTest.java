package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominatorTest {
    private Dominator dominator;

    @BeforeEach
    void setUp() {
        dominator = new Dominator();
    }

    @Test
    void test1() {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        int actual = dominator.solution(A);
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] A = {3};
        int actual = dominator.solution(A);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] A = {0, 0, 1, 1};
        int actual = dominator.solution(A);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[] A = {1, 1, 1, 0, 0, 0};
        int actual = dominator.solution(A);
        int expected = -1;
        assertEquals(expected, actual);
    }
}
