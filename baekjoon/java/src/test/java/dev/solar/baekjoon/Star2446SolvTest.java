package dev.solar.baekjoon;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Star2446SolvTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    public static Star2446Solv solv;

    @BeforeAll
    static void setUp() {
        System.setOut(new PrintStream(outContent));
        solv = new Star2446Solv();
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void test1() throws IOException {
        solv.star2446solv(5);
        String expected = "*********\n" +
                        " *******\n" +
                        "  *****\n" +
                        "   ***\n" +
                        "    *\n" +
                        "   ***\n" +
                        "  *****\n" +
                        " *******\n" +
                        "*********\n";
        assertEquals(expected, outContent.toString());
    }
}
