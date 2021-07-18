package dev.solar.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N1844 {
    private int[][] disit; //거리 계산
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        disit = new int[N][M];
        for (int n = 0; n < N; n++) {
            Arrays.fill(disit[n], -1); //아직 지나지 않은 길은 -1
        }

        // (0, 0) 좌표부터 탐색 시작
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        disit[0][0] = 1; //시작 위치의 거리를 0부터 시작

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int dir = 0; dir < 4; dir++) { //현재 좌표에서 4방면을 살펴보기
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (maps[x][y] == 0 || disit[x][y] != -1) { // 벽이거나, 이미 지나간 길인 경우
                    continue;
                }
                disit[x][y] = disit[cur.x][cur.y] + 1;
                q.add(new Point(x, y));
            }
        }

        return disit[N - 1][M - 1];
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
