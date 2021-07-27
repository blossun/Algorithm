package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Channel02Test {

    Channel02 channel02 = new Channel02();

    @Test
    void case01() {
        String road = "111011110011111011111100011111";
        int n = 3;
        int expected = 18;
        int actual = channel02.solution(road, n);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case02() {
        String road = "001100";
        int n = 5;
        int expected = 6;
        int actual = channel02.solution(road, n);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case03() {
        String road = "000111110";
        int n = 2;
        int expected = 7;
        int actual = channel02.solution(road, n);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void case04() {
        String road = "1110111101111101111110011111111";
        int n = 3;
        int expected = 22;
        int actual = channel02.solution(road, n);
        assertThat(actual).isEqualTo(expected);
    }
}
