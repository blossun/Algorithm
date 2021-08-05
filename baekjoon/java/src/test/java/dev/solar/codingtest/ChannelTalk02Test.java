package dev.solar.codingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChannelTalk02Test {
    ChannelTalk02 channelTalk02 = new ChannelTalk02();

    @Test
    void case01() {
        int[][] cars = {{0,0,3,0,0,0,0},{1,0,3,0,0,0,0},{0,0,3,0,0,0,0},{0,0,2,0,0,3,3},{2,2,2,0,2,0,0},{3,3,2,0,2,0,3},{3,3,2,0,2,0,4}};
        assertThat(channelTalk02.solution(cars)).isEqualTo(2);
    }

    @Test
    void case02() {
        int[][] cars = {{0,2,0,0,0},{0,4,2,0,0},{0,2,0,0,0},{0,0,0,2,1},{0,0,0,2,0}};
        assertThat(channelTalk02.solution(cars)).isEqualTo(0);
    }
}
