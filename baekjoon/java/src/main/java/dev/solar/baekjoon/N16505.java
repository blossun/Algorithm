package dev.solar.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N16505 {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int kan = (int) Math.pow(2, N);
        board = new char[kan][kan];
        star(0, 0, kan, false);

        // 출력
        for (int i = 0; i < kan; i++) {
            for (int j = 0; j < kan - i; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void star(int x, int y, int kan, boolean isBlank) {
        // 공백인 경우
        if (isBlank) {
            for (int i = x ; i < x + kan; i++) {
                for (int j = y; j < y + kan; j++) {
                    board[i][j] = ' ';
                }
            }
            return ;
        }

        //Base Condition
        if (kan == 1) {
            board[x][y] = '*';
            return ;
        }

        /*
        한 블록 사이즈 : 넘겨받은 칸수의 반
         */
        int size = kan / 2;
        int count = 0;
        for (int i = x; i < x + kan; i += size) {
            for (int j = y; j < y + kan; j += size) {
                count++;
                if (count == 4) {
                    star(i, j, size, true);
                }
                else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
