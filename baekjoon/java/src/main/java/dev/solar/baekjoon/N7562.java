package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N7562 {
    static int[][] disit;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int L; //체스판 길이
    static int startX, startY, endX, endY;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void dfs() {
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(startX, startY));
            disit[startX][startY] = 1;

            while (!q.isEmpty()) {
                Point cur = q.poll();

                // 목표 지점에 도달했으면 끝
                if (cur.x == endX && cur.y == endY) return ;

                //한 지점에서 다음 지점으로 이동할 수 있는 좌표의 갯수는 8가지
                for (int dir = 0; dir < 8; dir++) {
                    int x = cur.x + dx[dir];
                    int y = cur.y + dy[dir];
                    if (x < 0 || x >= L || y < 0 || y >= L) continue; //범위를 벗어난 경우
                    if (disit[x][y] > 0) continue; //이미 방문한 경우
                    disit[x][y] = disit[cur.x][cur.y] + 1;
                    q.add(new Point(x, y));
                }
            }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < testCase; i++) {
            L = Integer.parseInt(br.readLine().trim());
            disit = new int[L][L];

            String[] XY = br.readLine().split(" ");
            startX = Integer.parseInt(XY[0]);
            startY = Integer.parseInt(XY[1]);
            XY = br.readLine().split(" ");
            endX = Integer.parseInt(XY[0]);
            endY = Integer.parseInt(XY[1]);

            disit[startX][startY] = 1;
            dfs();

            System.out.println(disit[endX][endY] - 1);
            // 방문하지 않은 좌표를 -1로 초기화하지 않고, 0으로 사용하는 대신
            // 처음 시작 위치 이동 횟수를 1부터 시작해서 탐색 진행
            // 총 이동횟수 출력시 -1을 해주도록 구현
        }
    }
}

/*
나이트의 현재 위치에서 다음 확인해야할 좌표 위치를 인접한 네 방향이 아니라,
나이트가 이동할 수 있는 다음 위치값들을 dx, dy로 만들어서 BFS를 돌리면 된다.
 */
