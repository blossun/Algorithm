package dev.solar.baekjoon;

import java.io.*;

public class N1992 {
    static BufferedWriter bw;
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = br.read() - '0';
            }
            br.readLine();
        }
        divide(0, 0, N);
        bw.flush();
        bw.close();
    }

    private static void divide(int x, int y, int N) throws IOException {
        if (check(x, y, N)) { //4분면 값이 모두 같다면 해당 값만 출력
            bw.write(board[x][y] + "");
        } else {
            // 4분면 값이 다르다면
            bw.write("(");
            int size = N / 2;
            // 4분면을 나눠서 확인
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    divide(x + size * i, y + size * j, size);
                }
            }
            bw.write(")");
        }
    }

    private static boolean check(int x, int y, int N) {
        int tmp = board[x][y];
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
//                if (board[i][j] != board[i + 1][j + 1])
                if (board[i][j] != tmp)
                    return false;
            }
        }
        return true;
    }
}
