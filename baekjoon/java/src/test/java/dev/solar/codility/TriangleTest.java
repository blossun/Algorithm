package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    void test1() {
        int[] A = {-5, -5, 4, 5};
        assertEquals(125, triangle.solution(A));
    }

    @Test
    void test2() {
        int[] A = {-5, -2, 4, 5};
        assertEquals(50, triangle.solution(A));
    }

    @Test
    void test3() {
        int[] A = {-10, -7, -6, -5, -4};
        assertEquals(-120, triangle.solution(A));
    }

    @Test
    void test4() {
        int[] A = {1, 2, 3, 4, 5};
        assertEquals(60, triangle.solution(A));
    }

    @Test
    void test5() {
        int[] A = {-5, -3, 2, 4, 5};
        assertEquals(75, triangle.solution(A));
    }

    @Test
    void test6() {
        int[] A = {-5, -3, -2, 4, 5};
        assertEquals(75, triangle.solution(A));
    }
}
