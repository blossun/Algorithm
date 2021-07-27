package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Channel01Test {

    Channel01 channel01 = new Channel01();

    @Test
    void case01() {
        String time = "PM 01:00:00";
        int sec = 10;
        String expected = "13:00:10";
        String actual = channel01.solution(time, sec);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case02() {
        String time = "PM 11:59:59";
        int sec = 1;
        String expected = "00:00:00";
        String actual = channel01.solution(time, sec);
        assertThat(actual).isEqualTo(expected);
    }
}
