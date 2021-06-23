package dev.solar.programmers.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N77484Test {

    N77484 n77484 = new N77484();

    @Test
    void case01() {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] expected = {3, 5};
        int[] actual = n77484.solution(lottos, win_nums);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case02() {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        int[] expected = {1, 6};
        int[] actual = n77484.solution(lottos, win_nums);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case03() {
        int[] lottos = {0, 0, 0, 0, 0, 15};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        int[] expected = {1, 6};
        int[] actual = n77484.solution(lottos, win_nums);
        assertArrayEquals(expected, actual);
    }
}
