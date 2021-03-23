package dev.solar.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42578Test {
    private N42578 n42578;

    @BeforeEach
    void setUp() {
        n42578 = new N42578();
    }

    @Test
    void test1() {
        String[][] str = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int expected = 5;
        assertEquals(expected, n42578.solution(str));
    }
}
