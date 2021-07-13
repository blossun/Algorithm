package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42840Test {
    N42840 n42840 = new N42840();

    @Test
    void temp() {
        n42840.solution(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void case01() {
        int[] answers = {1,2,3,4,5};
        int[] expected = {1};
        int[] actual = n42840.solution(answers);
        assertArrayEquals(expected, actual);
    }
}
