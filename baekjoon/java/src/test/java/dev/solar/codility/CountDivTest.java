package dev.solar.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDivTest {
    private CountDiv countDiv;

    @BeforeEach
    void setUp() {
        countDiv = new CountDiv();
    }

    @Test
    void test1() {
        int actual = countDiv.solution(0, 1, 11);
        int expected = 1;
        System.out.println(Integer.MAX_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int actual = countDiv.solution(10, 10, 5);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int actual = countDiv.solution(1, 1, 11);
        int expected = 0;
        System.out.println(Integer.MAX_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int actual = countDiv.solution(0, 1, 1);
        int expected = 2;
        System.out.println(Integer.MAX_VALUE);
        assertEquals(expected, actual);
    }
}
