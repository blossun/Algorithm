package dev.solar.nhn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class n03Test {

    public static n03 n;

    @BeforeAll
    static  void setUp() {
        n = new n03();
    }

    @Test
    void t1() throws IOException {
        assertEquals(3, n.solution("aaaaabbc", 1));
    }

    @Test
    void t2() throws IOException {
        assertEquals(0, n.solution("aaaabbbbc", 5));
    }

    @Test
    void t3() throws IOException {
        assertEquals(1, n.solution("cbbaaazzzzz", 3));
    }
}
