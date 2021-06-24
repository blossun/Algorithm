package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42586Test {

    N42586 n42586 = new N42586();

    @Test
    void case01() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] expected = {2, 1};
        int[] actual = n42586.solution(progresses, speeds);
        assertArrayEquals(expected, actual);
    }

}
