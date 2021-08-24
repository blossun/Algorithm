package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N42628Test {
    N42628 n42628 = new N42628();

    @Test
    void case01() {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] expected = {333,-45};
        int[] actual = n42628.solution(operations);
        assertArrayEquals(expected, actual);
    }
}
