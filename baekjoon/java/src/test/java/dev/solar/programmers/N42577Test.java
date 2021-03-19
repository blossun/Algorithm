package dev.solar.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42577Test {
    private N42577 n42577;

    @BeforeEach
    void setUp() {
        n42577 = new N42577();
    }

    @Test
    void test1() {
        String[] strings = {"119", "97674223", "1195524421"};
        assertFalse(n42577.solution(strings));
    }

    @Test
    void test2() {
        String[] strings = {"123","456","789"};
        assertTrue(n42577.solution(strings));
    }

    @Test
    void test3() {
        String[] strings = {"12","123","1235","567","88"};
        assertFalse(n42577.solution(strings));
    }

    @Test
    void test4() {
        String[] strings = {"12345", "4567","456"};
        assertFalse(n42577.solution(strings));
    }
}
