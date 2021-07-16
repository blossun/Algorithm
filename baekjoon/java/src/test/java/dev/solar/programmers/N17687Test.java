package dev.solar.programmers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class N17687Test {
    N17687 n17687 = new N17687();

    @Test
    void temp() {
        int number = 4;
        int n = 2;
        String s = String.valueOf(number);
        number = Integer.parseInt(s, n);
        char[] actual = String.valueOf(number).toCharArray();
        char[] expected = {'1', '0'};
        assertArrayEquals(expected, actual);
    }

    @Test
    void temp2() {
        int number = 4;
        int n = 2;
        String actual = n17687.convertNumber(number, n);
        String expected = "100";
        assertEquals(actual, expected);
    }

    @Test
    void case01() {
        String actual = n17687.solution(2, 4, 2, 1);
        String expected = "0111";
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        String actual = n17687.solution(16, 16, 2, 1);
        String expected = "02468ACE11111111";
        assertEquals(expected, actual);
    }

    @Test
    void case03() {
        String actual = n17687.solution(16, 16, 2, 2);
        String expected = "13579BDF01234567";
        assertEquals(expected, actual);
    }
}
