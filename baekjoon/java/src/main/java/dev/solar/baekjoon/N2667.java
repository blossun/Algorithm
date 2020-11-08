package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N2667 {
    static int[][] board;
    static boolean[][] visit;
    static int N;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int BFS(Point cur, int width) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        visit[cur.x][cur.y] = true; //!!! 방문 표시 해줄 것!!!
        // 네 방향 확인
        for (int dir = 0; dir < 4; dir++) {
            int x = cur.x + dx[dir];
            int y = cur.y + dy[dir];
            if (x < 0 || x >= N || y < 0 || y >= N) continue; //범위를 벗어나면 skip
            if(board[x][y] != 1 || visit[x][y]) continue; //집이 없거나 방문한 곳이면 skip
            width = BFS(new Point(x, y), ++width);
        }

        return width;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        board = new int[N][N];
        visit = new boolean[N][N];

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                board[n][m] = br.read() - '0';
            }
            br.read();//개행제거
        }

        int count = 0; //단지 수
        List<Integer> widths = new ArrayList<>(); //단지별 총 단지 수
        //시작 위치
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (board[x][y] == 0 || visit[x][y]) continue; //집이 없거나 이미 방문한 경우
                // 새로운 단지 추가. 총단지 수는 1부터 시작
                count++;
                widths.add(BFS(new Point(x, y), 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count + "\n");
        Collections.sort(widths);
        for (Integer width : widths) {
            sb.append(width + "\n");
        }
        System.out.println(sb);

//        for (int n = 0; n < N; n++) {
//            for (int m = 0; m < N; m++) {
//                System.out.print(board[n][m]);
//            }
//            System.out.println();
//        }

    }
}
