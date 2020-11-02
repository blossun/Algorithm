package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7569 {
    static int[][][] board;
    static int[][][] days;
    static int[] dh = {0, 0, 1, -1, 0, 0};
    static int[] dm = {1, -1, 0, 0, 0, 0};
    static int[] dn = {0, 0, 0, 0, 1, -1};

    static int N;
    static int M;
    static int H;

    static class Point {
        int h;
        int m;
        int n;

        public Point(int h, int m, int n) {
            this.h = h; //h
            this.m = m; //m
            this.n = n; //n
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int N = Integer.parseInt(st.nextToken()); //열
        int M = Integer.parseInt(st.nextToken()); //행
        int H = Integer.parseInt(st.nextToken()); //높이
        int maxDay = 0;

        board = new int[H][M][N];
        days = new int[H][M][N];
        Queue<Point> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                for (int n = 0; n < N; n++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    board[h][m][n] = tomato;
                    if (tomato == 1) { // 익은 토마토는 0일(defualt), 모두 시작 위치로 하기 위해 큐에 저장
                        q.add(new Point(h, m, n));
                    }
                    if (tomato == 0) { //비어있는 부분 말고 안익은 토마토만 -1로 초기화
                        days[h][m][n] = -1;
                    }
                }
            }
        }

//        System.out.println("board-==========>");
//        for (int h = 0; h < H; h++) { //높이
//            for (int m = 0; m < M; m++) { //행
//                for (int n = 0; n < N; n++) { //열
//                    System.out.print(board[h][m][n]);
//                }
//                System.out.println();
//            }
//        }
//
//        System.out.println("days==========>");
//        for (int h = 0; h < H; h++) {
//            for (int m = 0; m < M; m++) {
//                for (int n = 0; n < N; n++) {
//                    System.out.print(days[h][m][n]);
//                }
//                System.out.println();
//            }
//        }

        while(!q.isEmpty()) {
            Point cur = q.poll();
//            System.out.println("cur - h : " + cur.h + ", m : " + cur.m + ", n : " + cur.n);
            for (int dir = 0; dir < 6; dir++) {// 여섯 방향 체크
                int n = cur.n + dn[dir];
                int m = cur.m + dm[dir];
                int h = cur.h + dh[dir];
//                System.out.println("h : " + h + ", m : " + m + ", n : " + n);
                if (n < 0 || n >= N || m < 0 || m >= M || h < 0 || h >= H) continue; //범위 벗어난 경우
                if (board[h][m][n] == -1 || days[h][m][n] >= 0) continue; //토마토가 들어있지 않고, 이미 방문한 경우
                q.add(new Point(h, m, n));
                days[h][m][n] = days[cur.h][cur.m][cur.n] + 1;
                maxDay = Math.max(maxDay, days[h][m][n]);
            }
        }

        //익지 않은 토마토가 남아있는지 확인
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (days[h][m][n] == -1) {
                        System.out.println("-1");
                        return ;
                    }
                }
            }
        }

        System.out.println(maxDay);

    }
}
