package dev.solar.programmers.weekly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N06Test {
    N06 n06 = new N06();

    @Test
    void case01() {
        int[] weights = {50,82,75,120};
        String[] head2haed = {"NLWL","WNLL","LWNW","WWLN"};
        int[] expected = {3, 4, 1, 2};
        assertArrayEquals(expected, n06.solution(weights, head2haed));
    }

    @Test
    void case02() {
        int[] weights = {60, 60, 60};
        String[] head2haed = {"NNN","NNN","NNN"};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, n06.solution(weights, head2haed));
    }
}
