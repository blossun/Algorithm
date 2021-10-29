package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N6593 {
    static int L, R, C;
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static char[][][] board;
    static int[][][] dist;
    static Point start;
    static Point end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                return;
            }
            board = new char[L][R][C];
            dist = new int[L][R][C];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String s = br.readLine();
//                    System.out.println(s);
//                    System.out.println("L : " + L + ", R : " + R + ", C : " + C);
                    for (int c = 0; c < C; c++) {
                        board[l][r][c] = s.charAt(c);
                        if (s.charAt(c) == 'S') {
                            start = new Point(l, r, c);
                        }
                        if (s.charAt(c) == 'E') {
                            end = new Point(l, r, c);
                        }
                    }
                }
                br.readLine();
            }

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    Arrays.fill(dist[l][r], -1);
                }
            }

            bfs(start);
            int result = dist[end.x][end.y][end.z];
            if (result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }

    private static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
//        q.offer(new Point(x, y, z));
        q.offer(start);
        dist[start.x][start.y][start.z] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                int z = cur.z + dz[i];
                if (x < 0 || x >= L || y < 0 || y >= R || z < 0 || z >= C) continue;
                if (dist[x][y][z] != -1 || board[x][y][z] == '#') continue;
                q.offer(new Point(x, y, z));
                dist[x][y][z] = dist[cur.x][cur.y][cur.z] + 1;

                if (board[x][y][z] == 'E') {
                    return;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int z;

        public Point(final int x, final int y, final int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
