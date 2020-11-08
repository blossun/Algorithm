package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N4179 {
    static char[][] board;
    static int[][] visit; //사람의 이동 시간
    static int[][] fire; //불의 전파 시간
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
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        board = new char[N][M];
        visit = new int[N][M];
        fire = new int[N][M];
        Queue<Point> fireQ = new LinkedList<>();
        Queue<Point> visitQ = new LinkedList<>();

        for (int n = 0; n < N; n++) {
            Arrays.fill(fire[n], -1); // fire -1로 초기화(방문하지 않은 위치)
            Arrays.fill(visit[n], -1); // visit -1로 초기화(방문하지 않은 위치)
        }

        // board 채우기
        // 입력받으면서 체크 - J면 visit 시작 위치로, F이면 fire 시작 위치로
        for (int n = 0; n < N; n++) {
            board[n] = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                char ch = board[n][m];
                if (ch == 'J') {
                    visit[n][m] = 0;
                    visitQ.add(new Point(n, m));
                }
                if (ch == 'F') {
                    fire[n][m] = 0;
                    fireQ.add(new Point(n, m));
                }
            }
        }

        // 먼저 불이 확산되는 경로 추적
        while (!fireQ.isEmpty()) {
            Point cur = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                // 벽이면 확산 안 됨.
                if (x < 0 || x >= N || y < 0 || y >= M) continue; //범위를 벗어나면 skip
                if (board[x][y] == '#' || fire[x][y] >= 0) continue; //벽이거나 이미 퍼진곳은 skip
                fire[x][y] = fire[cur.x][cur.y] + 1;
                fireQ.add(new Point(x, y));
            }
        }

//        for (int[] ints : fire) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }

        // 사람 경로
        while (!visitQ.isEmpty()) {
            Point cur = visitQ.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                // 벽이면 확산 안 됨.
                if (x < 0 || x >= N || y < 0 || y >= M) { //범위를 벗어났다는 것은 탈출했다는 의미
                    System.out.println(visit[cur.x][cur.y] + 1);
                    return;
                }
                if (board[x][y] == '#' || visit[x][y] >= 0) continue; //벽이거나 이미 방문한 곳은 skip
                if (fire[x][y] != -1 && fire[x][y] <= visit[cur.x][cur.y] + 1)
                    continue; //벽이거나 불이 먼저 붙은 곳은 가지 못함. 숫자가 낮다는 것은 먼저 도착했다는 의미
                visit[x][y] = visit[cur.x][cur.y] + 1;
                visitQ.add(new Point(x, y));
            }
        }

//        for (int[] ints : visit) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }
        // 여기까지 왔다면 탈출하지 못한 것
        System.out.println("IMPOSSIBLE");

    }
}
