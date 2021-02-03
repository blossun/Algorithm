package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N10026 {

    static char[][] boardRGB;
    static char[][] boardRB;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static int r = 0;
    static int g = 0;
    static int b = 0;

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
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        boardRGB = new char[N][N];
        boardRB = new char[N][N];
        visit = new boolean[N][N];
        int count = 0; //영역의 수
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = line.charAt(j);
                boardRGB[i][j] = ch;
                boardRB[i][j] = (ch == 'G') ? 'R' : ch;
            }
        }
        // 탐색 시작 위치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 시작 지점 (i, j)는 새로운 영역의 시작점
                if (visit[i][j]) continue; //방문한 곳이면 skip
                count++;
                visitArea(new Point(i, j), boardRGB);
            }
        }
        //1. 적록색약이 아닌 사람 2. 적록색약인 사람
        System.out.print(count + " ");

        // 초기화
        count = 0;
        for (boolean[] vis : visit) {
            Arrays.fill(vis, false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 시작 지점 (i, j)는 새로운 영역의 시작점
                if (visit[i][j]) continue; //방문한 곳이면 skip
                count++;
                visitArea(new Point(i, j), boardRB);
            }
        }
        System.out.print(count + " ");
    }

    private static void visitArea(Point point, char[][] board) {
        Queue<Point> q = new LinkedList<>();
        char curColor = board[point.x][point.y];
        visit[point.x][point.y] = true;
        q.add(point);
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (x < 0 || x >= N || y < 0 || y >= N) continue; //범위를 벗어난 경우
                if (visit[x][y] || (board[x][y] != curColor)) continue; // 방문했거나 다른 색상(영역)인 경우
                visit[x][y] = true;
                q.add(new Point(x, y));
            }
        }
    }

}
