package dev.solar.baekjoon;

import java.util.Scanner;

public class N9663 {
    static boolean[] isUsedCol; // column을 차지하고 있는지
    static boolean[] isUsedDiagonal1; // / 방향 대각선을 차지하고 있는지
    static boolean[] isUsedDiagonal2; // \ 방향 대각선을 차지하고 있는지
    static int N;
    static int count = 0; //퀸을 놓는 방법의 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        isUsedCol = new boolean[N];
        isUsedDiagonal1 = new boolean[N * 3]; //N 크기로 지정하면 안됨!! 대각선이므로 더 크게
        isUsedDiagonal2 = new boolean[N * 3];
        queen(0);
        System.out.println(count);
    }

    private static void queen(int cur) { // cur번째 row에 말을 배치할 예정임
        if (cur == N) { // N개를 놓는데 성공했다면
            count++;
            return ;
        }
        for (int y = 0; y < N; y++) { // (cur, i)에 퀸을 놓을 예정
            if (isUsedCol[y] || isUsedDiagonal1[cur + y] || isUsedDiagonal2[cur - y + N - 1]) // column이나 대각선 중에 문제가 있다면
                continue;
            // if를 넘어갔다는 것은 해당 좌표에 놓을 수 있다는 것.
            // 그러므로 해당 좌표에 놨을 때, 위치하면 안되는 퀸들의 자리(현재 퀸이 전진할 수 있는 자리를 셋팅
            isUsedCol[y] = true;
            isUsedDiagonal1[cur + y] = true;
            isUsedDiagonal2[cur - y + N - 1] = true;
            queen(cur + 1); //다음 row에 말을 배치
            isUsedCol[y] = false; //주의! 함수를 빠져나올 때 false로 만들어 줘야함!!!
            isUsedDiagonal1[cur + y] = false;
            isUsedDiagonal2[cur - y + N - 1] = false;
        }
    }
}
