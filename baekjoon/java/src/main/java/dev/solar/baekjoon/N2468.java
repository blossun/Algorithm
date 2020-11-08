package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2468 {
    static int[][] board;
    static boolean[][] rainedBoard;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int maxHight = 0; //최대 높이
    static int maxDivide = 0;

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
        board = new int[N][N];
        rainedBoard = new boolean[N][N];

        // board 채우기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int m = 0; m < N; m++) {
                int hight = Integer.parseInt(st.nextToken()); //1 ~ 100 사이의 값이 나올 수 있으므로 아스키로 형변환 하지 않음
                board[n][m] = hight;
                maxHight = Math.max(maxHight, hight);
            }
        }

        // hight : 0 ~ maxHignt 까지 bfs()로 최대 안전영역 확인
        for (int h = 0; h < maxHight; h++) {
            rain(h); //현재 높이에서 물에 잠기는 지역 표시
            visit = new boolean[N][N];
            int divided = 0;
            
            // 새로 나뉘는 영역은 새로 bfs를 도는 시작 지점
            for (int xi = 0; xi < N; xi++) {
                for (int yi = 0; yi < N; yi++) {
                    if (rainedBoard[xi][yi] || visit[xi][yi]) continue; //비에 잠겼고 이미 방문했으면 skip
                    divided = bfs(divided, xi, yi);
                }
            }
            maxDivide = Math.max(divided, maxDivide);
        }

        System.out.println(maxDivide);
    }

    private static int bfs(int divided, int xi, int yi) {
        Queue<Point> q = new LinkedList<>();
        visit[xi][yi] = true;
        q.add(new Point(xi, yi));
        divided++;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            //네 방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (x < 0 || x >= N || y < 0 || y >= N) continue;
                if (rainedBoard[x][y] || visit[x][y]) continue; //비에 잠겼거나 방문한 곳이면 skip
                visit[x][y] = true;
                q.add(new Point(x, y));
            }

        }
        return divided;
    }

    private static void rain(int h) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (board[x][y] <= h)
                    rainedBoard[x][y] = true; //높이보다 낮으면 물에 잠긴 지역
            }
        }
    }
}
/*
강수량이 제일 낮은 것부터 bfs로 안전지대를 파악하고
강수량을 높였을 때 안전지대 수가 이전보다 줄어들면 끝?
강수량이 더 높은데 안전지대 수가 더 많이 나오는 경우가 있나? -> 있음!!. 전체 영역의 넓이가 아니라 구분되는 영역의 수니깐
입력 받을 때 최대 높이를 따로 저장해둬야함.
최대 높이를 넘어가면 모두 잠기므로 탐색 종료
 */
