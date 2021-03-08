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
}
