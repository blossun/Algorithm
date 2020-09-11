package dev.solar.baekjoon;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Star2447SolvTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    public static Star2447Solv solv;

    @BeforeAll
    static void setUp() {
        System.setOut(new PrintStream(outContent));
        solv = new Star2447Solv();
    }

    @AfterAll
    static void reestoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName("n = 3")
    @Test
    void test1() throws IOException {
        solv.start2447Solv(3);
        String expected =
                "***\n" +
                "* *\n" +
                "***\n";
        assertEquals(expected, outContent.toString());
    }

    @DisplayName("n = 9")
    @Test
    void test2() throws IOException {
        solv.start2447Solv(9);
        String expected =
                        "*********\n" +
                        "* ** ** *\n" +
                        "*********\n" +
                        "***   ***\n" +
                        "* *   * *\n" +
                        "***   ***\n" +
                        "*********\n" +
                        "* ** ** *\n" +
                        "*********\n";
        assertEquals(expected, outContent.toString());
    }

    @DisplayName("n = 27")
    @Test
    void test3() throws IOException {
        solv.start2447Solv(27);
        String expected =
                        "***************************\n" +
                        "* ** ** ** ** ** ** ** ** *\n" +
                        "***************************\n" +
                        "***   ******   ******   ***\n" +
                        "* *   * ** *   * ** *   * *\n" +
                        "***   ******   ******   ***\n" +
                        "***************************\n" +
                        "* ** ** ** ** ** ** ** ** *\n" +
                        "***************************\n" +
                        "*********         *********\n" +
                        "* ** ** *         * ** ** *\n" +
                        "*********         *********\n" +
                        "***   ***         ***   ***\n" +
                        "* *   * *         * *   * *\n" +
                        "***   ***         ***   ***\n" +
                        "*********         *********\n" +
                        "* ** ** *         * ** ** *\n" +
                        "*********         *********\n" +
                        "***************************\n" +
                        "* ** ** ** ** ** ** ** ** *\n" +
                        "***************************\n" +
                        "***   ******   ******   ***\n" +
                        "* *   * ** *   * ** *   * *\n" +
                        "***   ******   ******   ***\n" +
                        "***************************\n" +
                        "* ** ** ** ** ** ** ** ** *\n" +
                        "***************************\n";
        assertEquals(expected, outContent.toString());
    }
}
