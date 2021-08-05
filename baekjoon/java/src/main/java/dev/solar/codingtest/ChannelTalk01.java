package dev.solar.codingtest;

import java.util.stream.Stream;

public class ChannelTalk01 {
    public int solution(int[][] locations) {
        int answer = 0;
//        boolean[][] mine = new boolean[3][3];
        for (int i = 0; i < locations.length; i++) {
            int x = locations[i][0];
            int y = locations[i][1];
            if (x == 2 && y == 2) {
                return -1;
            }
            answer++;
        }
        return answer;
    }
}
