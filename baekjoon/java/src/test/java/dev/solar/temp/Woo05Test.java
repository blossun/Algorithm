package dev.solar.temp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Woo05Test {
    Woo05 woo05 = new Woo05();

    @Test
    void case01() {
        int number = 13;
        assertEquals(4, woo05.Solution(number));
    }

    @Test
    void case02() {
        int number = 33;
        assertEquals(14, woo05.Solution(number));
    }

}
