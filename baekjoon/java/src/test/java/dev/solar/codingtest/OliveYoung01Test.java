package dev.solar.codingtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OliveYoung01Test {

    OliveYoung01 oliveYoung01 = new OliveYoung01();

    @Test
    void case01() {
        int[] x = {5};
        int[] y = {5};
        int[] r = {5};
        int[] v = {92, 83, 14, 45, 66, 37, 28, 9, 10, 81};
        int expected = 80;
        int actual = oliveYoung01.solution(x, y, r, v);
        Assertions.assertEquals(expected, actual);
    }
}
