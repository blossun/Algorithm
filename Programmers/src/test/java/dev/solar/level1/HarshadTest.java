package dev.solar.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HarshadTest {
    Harshad harshad = new Harshad();

    @Test
    void ex1() {
        assertEquals(true, harshad.solution(10));
    }

    @Test
    void ex2() {
        assertEquals(true, harshad.solution(12));
    }

    @Test
    void ex3() {
        assertEquals(false, harshad.solution(11));
    }

    @Test
    void ex4() {
        assertEquals(false, harshad.solution(13));
    }
}
