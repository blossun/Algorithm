package dev.solar.kakao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N17682Test {

    N17682 n17682 = new N17682();

    @Test
    void case01() {
        String dartResult = "1S2D*3T";
        int expected = 37;
        int actual = n17682.solution(dartResult);
        assertEquals(expected, actual);
    }

}
