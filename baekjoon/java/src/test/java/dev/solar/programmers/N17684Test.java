package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N17684Test {
    N17684 n17684 = new N17684();

    @Test
    void case01() {
        String msg = "KAKAO";
        int[] expected = {11, 1, 27, 15};
        int[] actual = n17684.solution(msg);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case02() {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        int[] expected = {20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34};
        int[] actual = n17684.solution(msg);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case03() {
        String msg = "ABABABABABABABAB";
        int[] expected = {1, 2, 27, 29, 28, 31, 30};
        int[] actual = n17684.solution(msg);
        assertArrayEquals(expected, actual);
    }
}
