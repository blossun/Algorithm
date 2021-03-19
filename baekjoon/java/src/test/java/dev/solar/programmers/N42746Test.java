package dev.solar.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42746Test {
    private N42746 n42746;

    @BeforeEach
    void setUp() {
        n42746 = new N42746();
    }

    @Test
    void test1() {
        int[] numbers = {6, 10, 2};
        assertEquals("6210", n42746.solution(numbers));
    }

    @Test
    void test2() {
        int[] numbers = {3, 30, 34, 5, 9};
        assertEquals("9534330", n42746.solution(numbers));
    }

    @Test
    void test3() {
        int[] numbers = {1, 1};
        assertEquals("11", n42746.solution(numbers));
    }

    @Test
    void test4() {
        int[] numbers = {0, 1, 2, 23, 2};
        assertEquals("232210", n42746.solution(numbers));
    }

    @Test
    void test5() {
        int[] numbers = {0, 1, 2, 1, 2, 0, 21};
        assertEquals("22211100", n42746.solution(numbers));
    }

    @Test
    void test6() {
        int[] numbers = {12, 121};
        assertEquals("12121", n42746.solution(numbers));
    }

    @Test
    void test7() {
        int[] numbers = {3, 30, 34, 4, 40, 42, 421, 423, 45};
        assertEquals("454424234214034330", n42746.solution(numbers));
    }

    @Test
    void test8() {
        int[] numbers = {0, 0};
        assertEquals("0", n42746.solution(numbers));
    }

    @Test
    void test9() {
        int[] numbers = {2, 0, 0};
        assertEquals("200", n42746.solution(numbers));
    }
}
