package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N12930Test {

    private N12930 S = new N12930();

    @Test
    void case1() {
        String str = "try hello world";
        String expected = "TrY HeLlO WoRlD";
        assertEquals(expected, S.solution(str));
    }

}
