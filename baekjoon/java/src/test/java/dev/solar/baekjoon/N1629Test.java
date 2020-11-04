package dev.solar.baekjoon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N1629Test {
    public static N1629 n1629;

    @BeforeAll
    static void setUp() {
        n1629 = new N1629();
    }

    @Test
    void t1() {
        assertEquals(2, N1629.recursiveMod(2, 1, 3));
    }

    @Test
    void t2() {
        assertEquals(4, N1629.recursiveMod(12, 58, 67));
    }

}
