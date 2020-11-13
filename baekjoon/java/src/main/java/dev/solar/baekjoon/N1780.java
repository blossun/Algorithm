package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1780 {
    static int[] cnt = new int[3]; //0 -> -1, 1 -> 0, 2 -> 1
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int y = 0; y < N; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    private static void divide(int x, int y, int N) {
        if (check(x, y, N)) {
            cnt[board[x][y] + 1]++; //값에 +1한 인덱스의 값을 +1함.
            return ;
        }

        // 값이 다르면 9분할 해서 확인
        int size = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(x + size * i, y + size * j, size);
            }
        }

    }

    private static boolean check(int x, int y, int size) { //해당 블록이 모두 같은 값인지 확인
//        System.out.println("board["+ x + "][" + y + "] : " + board[x][y] + ", size : " + size);
        int tmp = board[x][y]; //첫번째 값
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) { //첫번째 값과 다른 값이 나오는지 계속해서 확인
                if (tmp != board[i][j]) //다른 값이 나오면
                    return false;
            }
        }
        return true; //모두 같은 값이면
    }
}
