package dev.solar.naver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test3Test {
    private static Test3 test3;

    @BeforeEach
    void setUp() {
        test3 = new Test3();
    }

    @Test
    void test1() {
        int actual = test3.solution(1, 8, 3, 2);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int actual = test3.solution(3, 2, 1, 1);
        int expected = 9;
        assertEquals(expected, actual);
    }


}
