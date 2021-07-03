package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Mobility03Test {

    Mobility03 mobility03 = new Mobility03();

    @Test
    void case01() {
        int[] A = {7, 4, -2, 4, -2, -9};
        int expected = 4;
        int actual = mobility03.solution(A);
        assertEquals(expected, actual);
    }
}
