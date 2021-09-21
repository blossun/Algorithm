package dev.solar.temp;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class Woo06Test {
    Woo06 woo06 = new Woo06();

    @Test
    void case01() throws ParseException {
        String[] logs = {
                "woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02"
        };
        int totalTicket = 2000;
        String[] expected = {"jason", "woni"};
        assertArrayEquals(expected, woo06.solution(totalTicket, logs));
    }
}
