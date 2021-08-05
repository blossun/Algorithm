package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChannelTalk04Test {
    ChannelTalk04 channelTalk04 = new ChannelTalk04();

    @Test
    void case01() {
        int n = 2;
        int m = 2;
        int k = 5;
        String expected = ")()(";
        assertThat(channelTalk04.solution(n, m, k)).isEqualTo(expected);
    }
}
