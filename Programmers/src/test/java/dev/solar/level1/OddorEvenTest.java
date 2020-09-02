package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddorEvenTest {
    OddorEven oddorEven = new OddorEven();

    @Test
    void test1() {
        assertEquals("Odd", oddorEven.solution(3));
    }

    @Test
    void test2() {
        assertEquals("Even", oddorEven.solution(4));
    }

    @Test
    void test3() {
        assertEquals("Even", oddorEven.solution(0));
    }
}
