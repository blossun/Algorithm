package dev.solar.baekjoon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

import static java.lang.System.currentTimeMillis;
import static org.junit.jupiter.api.Assertions.*;

class MinPrice5543MainTest {
    private static final org.slf4j.Logger log = (Logger) org.slf4j.LoggerFactory.getLogger(MinPrice5543MainTest.class);
    public static Solv5543 solv;

    @BeforeAll
    static void setUp() {
        solv = new Solv5543();
    }

    @DisplayName("정확성 테스트")
    @Test
    void test1() {
        int[] bugers = {800, 700, 900};
        int[] beverages = {198, 330};
        int expected = 848;
        int actual = solv.solv(bugers, beverages);
        assertEquals(expected, actual);
    }

    @DisplayName("효율성 테스트")
    @Test
    void test() {
        int[] bugers = {800, 700, 900};
        int[] beverages = {198, 330};
        long t1 = currentTimeMillis();
        log.debug(String.valueOf(solv.solv(bugers, beverages)));
        long t2 = currentTimeMillis();
        log.debug("실행 시간 : {}", t2 - t1);
    }
}
