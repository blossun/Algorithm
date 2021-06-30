package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N12953Test {

    N12953 n12953 = new N12953();

    @Test
    void case01() {
        int[] arr = {12, 7, 4, 3, 2, 1};
        int expected = 84;
        int actual = n12953.solution(arr);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] arr = {3, 4, 9, 16};
        int expected = 144;
        int actual = n12953.solution(arr);
        assertEquals(expected, actual);
    }
}
