package dev.solar.programmers;

public class N12913 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        dp[0] = land[0].clone();
        for (int i = 1; i < land.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]) + land[i][0];
            dp[i][1] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][2]), dp[i - 1][3]) + land[i][1];
            dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][3]) + land[i][2];
            dp[i][3] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]) + land[i][3];
        }
        return Math.max(Math.max(Math.max(dp[land.length - 1][0], dp[land.length - 1][1]), dp[land.length - 1][2]), dp[land.length - 1][3]);
    }
}
