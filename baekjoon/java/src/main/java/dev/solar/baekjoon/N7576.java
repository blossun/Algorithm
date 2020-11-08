package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7576 {
    static int[][] board;
    static int[][] days;
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
        M = Integer.parseInt(st.nextToken()); //행,열 구분 잘해줄 것
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        days = new int[N][M];

        Queue<Point> q = new LinkedList<>();
        int maxDays = 0;

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int m = 0; m < M; m++) {
                board[n][m] = Integer.parseInt(st.nextToken());
                if (board[n][m] == 1) //모든 시작위치(익은 토마토)를 큐에 저장
                    q.add(new Point(n, m));
                if (board[n][m] == 0) //안 익은 토마토는 dist를 -1로 초기화
                    days[n][m] = -1;
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (x < 0 || x >= N || y < 0 || y >= M) continue; //범위 밖인 경우
                if (board[x][y] == -1 || days[x][y] >= 0) continue; //토마토가 안들어있거나 이미 익은 경우 //0보다 크거나 같은 경우로 체크해야함!!
                days[x][y] = days[cur.x][cur.y] + 1; //익을 날짜 +1
                maxDays = Math.max(maxDays, days[x][y]); //모두 익을 최소 날짜
                q.add(new Point(x, y));
            }
        }

        // 모두익지 않은 상황이면 -1 출력
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (board[n][m] == 0 && days[n][m] == -1) {
                    System.out.println("-1");
                    return ;
                }
            }
        }

        System.out.println(maxDays);

    }
}
