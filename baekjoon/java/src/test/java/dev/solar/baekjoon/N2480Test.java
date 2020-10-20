package dev.solar.baekjoon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class N2480Test {
    public static N2480 n2480;
    public static InputStream in;

    @BeforeAll
    static void setUp() {
        n2480 = new N2480();
    }

    @Test
    void 세수동일() {
        int[] numbs = {6, 6, 6};
        assertEquals(16000, n2480.solv(numbs));
    }

}
