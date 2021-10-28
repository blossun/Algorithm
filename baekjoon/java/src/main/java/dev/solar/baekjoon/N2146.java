package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬마다 다른 번호를 부여해준다.
public class N2146 {
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int landNumber = 2;
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬에 번호 부여
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) { //아직 번호가 부여되지 않은 섬
                    giveNumber(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] >= 2) { //섬인 경우 시작 포인트로
                    visit = new boolean[N][N]; // 재초기화!!! 방문 다시 확인 필요
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(final int i, final int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j, 0));
        int currentLand = board[i][j]; // 현재 섬
        visit[i][j] = true; //방문표시

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = cur.x + dx[k];
                int y = cur.y + dy[k];
                if (x < 0 || x >= N || y < 0 || y >= N) continue; //board를 벗어난 경우
                if (visit[x][y] || board[x][y] == currentLand) continue;

                visit[x][y] = true;
                if (board[x][y] == 0) { //바다
                    q.offer(new Point(x, y, cur.cost + 1));
                } else { //다른 섬
                    answer = Math.min(answer, cur.cost);
                }
            }
        }
    }

    private static void giveNumber(final int i, final int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j, 0));
        visit[i][j] = true;
        board[i][j] = landNumber;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = cur.x + dx[k];
                int y = cur.y + dy[k];
                if (x < 0 || x >= N || y < 0 || y >= N) continue;
                if (visit[x][y] || board[x][y] != 1) continue;
                visit[x][y] = true;
                board[x][y] = landNumber;
                q.offer(new Point(x, y, 0));
            }
        }
        landNumber++;
    }

    static class Point {
        int x;
        int y;
        int cost;

        public Point(final int x, final int y, final int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
