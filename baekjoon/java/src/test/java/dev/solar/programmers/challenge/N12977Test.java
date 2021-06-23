package dev.solar.programmers.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N12977Test {

    N12977 n12977 = new N12977();

    @Test
    void case01() {
        int[] nums = {1, 2, 3, 4};
        int expected = 1;
        int actual = n12977.solution(nums);
        assertEquals(expected, actual);
    }
}
