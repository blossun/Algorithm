package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {
    static int[][] board;
    static int[][] disit; //거리계산
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        disit = new int[N][M];

        // board 입력 받기
        for (int n = 0; n < N; n++) {
            /*1. 오래 걸리는 코드*/
//            String arr[] = br.readLine().trim().split("");
//            board[n] = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
            /*2. 최적화된 코*/
            char[] charr = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                board[n][m] = charr[m] - '0';
            }
        }

        // visit 배열 방문 여부를 -1(방문안함)으로 초기화
        for (int n = 0; n < N; n++) {
            Arrays.fill(disit[n], -1);
        }

        // (0, 0) 좌표 부터 탐색 시작
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        disit[0][0] = 0; //시작 위치 거리를 0부터 시작

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (x < 0 || x >= N || y < 0 || y >= M) continue; //범위 밖이면 skip
                if (board[x][y] != 1 || disit[x][y] != -1) continue; //길이 아니거나 이미 방문한 경우 skip
                disit[x][y] = disit[cur.x][cur.y] + 1; //중심 좌표의 거리값에서 +1
                q.add(new Point(x, y));
            }
        }

        System.out.println(disit[N-1][M-1] + 1); //문제에서는 (0, 0)거리를 1부터 계산하기 때문에 마지막에 +1

    }
}
