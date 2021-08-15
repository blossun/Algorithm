package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1261 {
    static int[][] board;
    static int[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new int[N][M];
        for (int[] ints : visited) {
            Arrays.fill(ints, -1);
        }

        Deque<Point> deque = new LinkedList<>();
        deque.offer(new Point(0, 0));
        visited[0][0] = 0;

        while(!deque.isEmpty()) {
           Point cur = deque.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (visited[x][y] != -1) continue;
                if (board[x][y] == 1) {
                    visited[x][y] = visited[cur.x][cur.y] + 1;
                    deque.addLast(new Point(x, y));
                } else {
                    visited[x][y] = visited[cur.x][cur.y];
                    deque.addFirst(new Point(x, y));
                }
            }
        }

        System.out.println(visited[N-1][M-1]);
    }

    static class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
