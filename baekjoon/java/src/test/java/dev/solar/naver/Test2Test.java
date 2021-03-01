package dev.solar.naver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test2Test {

    private Test2 test2;

    @BeforeEach
    void setUp() {
        test2 = new Test2();
    }

    @Test
    void test1() {
        int[] arr = {0, 1, 1, 1, 0, 1, 1, 1, 0, 1};
        assertEquals(1, test2.solution(arr));
    }

    @Test
    void test2() {
        int[] arr = {0, 0};
        assertEquals(-1, test2.solution(arr));
    }

    @Test
    void test3() {
        int[] arr = {0, 1};
        assertEquals(1, test2.solution(arr));
    }

    @Test
    void test4() {
        int[] arr = {1, 1};
        assertEquals(0, test2.solution(arr));
    }

    @Test
    void test5() {
        int[] arr = {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        assertEquals(5, test2.solution(arr));
    }

    @Test
    void test6() {
        int[] arr = {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        assertEquals(0, test2.solution(arr));
    }
}
