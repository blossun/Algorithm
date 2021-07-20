package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N72411Test {

    N72411 n72411 = new N72411();

    @Test
    void case01() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] expected = {"AC", "ACDE", "BCFG", "CDE"};
        String[] actual = n72411.solution(orders, course);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case02() {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3,5};
        String[] expected = {"ACD", "AD", "ADE", "CD", "XYZ"};
        String[] actual = n72411.solution(orders, course);
        assertArrayEquals(expected, actual);
    }

    @Test
    void case03() {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        String[] expected = {"WX", "XY"};
        String[] actual = n72411.solution(orders, course);
        assertArrayEquals(expected, actual);
    }
}
