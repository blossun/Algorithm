package dev.solar.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42587Test {
    private N42587 n42587;

    @BeforeEach
    void setUp() {
        n42587 = new N42587();
    }

    @Test
    void test1() {
        int[] priorities = {2, 1, 3, 2};
        assertEquals(1, n42587.solution(priorities, 2));
    }

    @Test
    void test2() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        assertEquals(5, n42587.solution(priorities, 0));
    }
}
