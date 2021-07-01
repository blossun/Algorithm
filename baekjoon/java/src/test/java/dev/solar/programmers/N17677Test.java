package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N17677Test {

    N17677 n17677 = new N17677();

    @Test
    void case01() {
        String str1 = "FRANCE";
        String str2 = "french";
        int expected = 16384;
        assertEquals(expected, n17677.solution(str1, str2));
    }

    @Test
    void temp() {
        System.out.println(Math.round(2 / (double)8 * 65536));
    }
}
