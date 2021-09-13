package dev.solar.programmers;

import java.util.Arrays;

public class N42898 {
    public int solution(int m, int n, int[][] puddles) {

        int[][] board = new int[n][m];
        for (int[] line : board) {
            Arrays.fill(line, -1);
        }

        // 물에 잠긴 지역 표시
        for (int[] puddle : puddles) {
            board[puddle[1] - 1][puddle[0] - 1] = 0;
        }

        // 집 위치
        board[0][0] = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] != -1) continue;
                int cnt = 0;
                // 왼쪽 경우의 수
                cnt = col == 0 ? 0 : board[row][col - 1] % 1_000_000_007;
                // 위쪽 경우의 수
                cnt += row == 0 ? 0 : board[row - 1][col] % 1_000_000_007;
                board[row][col] = cnt;
            }
        }
        return board[n - 1][m - 1]  % 1_000_000_007;
    }
}
