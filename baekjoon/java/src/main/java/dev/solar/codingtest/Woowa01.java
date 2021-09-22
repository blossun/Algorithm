package dev.solar.codingtest;

import java.util.Arrays;

public class Woowa01 {
    public String solution(int U, int L, int[] C) {
        int columns = C.length;
        int[][] board = new int[2][columns];
        int numberOfTwo = 0;
        int numberOfZero = 0;

        for (int i = 0; i < columns; i++) {
            if (C[i] == 2) {
                board[0][i] = 1;
                board[1][i] = 1;
                numberOfTwo++;
                continue;
            }
            if (C[i] == 0) {
                board[0][i] = 0;
                board[1][i] = 0;
                numberOfZero++;
                continue;
            }
            board[0][i] = -1; //1또는 0으로 채워야하는 자리
            board[1][i] = -1;
        }

        //필요한 1의 자리 갯수 = U(L) - 2의 갯수
        int needOneForU = U - numberOfTwo;
        int needOneForL = L - numberOfTwo;
        // 채워야하는 1의 자리 갯수 = 컬럼 수 - (2의 갯수 + 0의 갯수)
        int usableColumns = columns - (numberOfTwo + numberOfZero);
        if (usableColumns != (needOneForL + needOneForU)) {
            return "IMPOSSIBLE";
        }

        for (int i = 0; i < columns; i++) {
            if (needOneForU <= 0) {
                break;
            }
            if (board[0][i] == -1) {
                board[0][i] = 1;
                board[1][i] = 0;
                needOneForU--;
            }
        }

        for (int i = 0; i < columns; i++) {
            if (needOneForL <= 0) {
                break;
            }
            if (board[0][i] == -1) {
                board[0][i] = 0;
                board[1][i] = 1;
                needOneForL--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            Arrays.stream(row).forEach(sb::append);
            sb.append(',');
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
