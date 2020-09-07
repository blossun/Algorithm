package dev.solar.baekjoon;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;

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

    @DisplayName("정확성")
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

    @DisplayName("시간 제한 - 1초")
    @Test
    void timeout() {
        assertTimeout(Duration.ofMillis(1000), () -> solv.star2446solv(5)); //1000 ms = 1s
    }

    @DisplayName("시간 제한 - 0.5초")
    @Test
    void timeout2() {
        assertTimeout(Duration.ofMillis(500), () -> solv.star2446solv(5)); //1000 ms = 1s
    }

    @DisplayName("시간 제한 - 0.2초")
    @Test
    void timeout3() {
        assertTimeout(Duration.ofMillis(200), () -> solv.star2446solv(5)); //1000 ms = 1s
    }
}
