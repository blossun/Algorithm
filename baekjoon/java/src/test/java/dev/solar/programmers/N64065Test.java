package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N64065Test {
    N64065 n64065 = new N64065();

    @Test
    void case01() {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] expected = {2, 1, 3, 4};
        int[] actual = n64065.solution(s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case02() {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] expected = {2, 1, 3, 4};
        int[] actual = n64065.solution2(s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case03() {
        String s = "{{1,2,3},{3,2},{1,2,2,3},{2}}";
        int[] expected = {2, 3, 1, 2};
        int[] actual = n64065.solution2(s);
        assertArrayEquals(expected, actual);
    }
}
