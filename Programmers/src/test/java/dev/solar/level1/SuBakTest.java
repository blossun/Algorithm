package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuBakTest {
    SuBak suBak = new SuBak();

    @Test
    void 수박() {
        assertEquals("수박수", suBak.solution(3));
    }

    @Test
    void 수박수박() {
        assertEquals("수박수박", suBak.solution(4));
    }
}
