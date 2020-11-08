package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1012 {
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N; //행
    static int M; //열

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
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            visit = new boolean[N][M];
            int count = 0; //필요한 지렁이 수

            int K = Integer.parseInt(st.nextToken()); //배추 위치 갯수
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            Queue<Point> q = new LinkedList<>();

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (board[n][m] != 1 || visit[n][m]) continue; //배추가 심어져있지 않거나 이전에 방문한 곳이면 skip
                    count++; //시작위치면 지렁이 수 +1
                    visit[n][m] = true; //시작위치 방문 표시
                    q.add(new Point(n, m)); //시작 위치 큐에 담기

                    while (!q.isEmpty()) {
                        Point cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) { // 네 방향 확인
                            int x = cur.x + dx[dir];
                            int y = cur.y + dy[dir];
                            if (x < 0 || x >= N || y < 0 || y >= M) continue; //범위 박이면 skip
                            if (board[x][y] == 0 || visit[x][y]) continue; //배추가 없거나 이전에 방문한 곳이면 skip
                            visit[x][y] = true;
                            q.add(new Point(x, y));
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}
