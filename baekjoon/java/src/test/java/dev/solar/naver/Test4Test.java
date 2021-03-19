package dev.solar.naver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test4Test {
    private Test4 test4;

    @BeforeEach
    void setUp() {
        test4 = new Test4();
    }

    @Test
    void test1() {
        String S = "abccbd";
        int[] C = {0, 1, 2, 3, 4, 5};
        assertEquals(2, test4.solution(S, C));
    }

    @Test
    void test2() {
        String S = "aa";
        int[] C = {2, 1};
        assertEquals(1, test4.solution(S, C));
    }

    @Test
    void test3() {
        String S = "aa";
        int[] C = {1, 2};
        assertEquals(1, test4.solution(S, C));
    }

    @Test
    void test4() {
        String S = "aaa";
        int[] C = {2, 3, 1};
        assertEquals(3, test4.solution(S, C));
    }

    @Test
    void test5() {
        String S = "aabbcc";
        int[] C = {1, 2, 1, 2, 1, 2};
        assertEquals(3, test4.solution(S, C));
    }
}
