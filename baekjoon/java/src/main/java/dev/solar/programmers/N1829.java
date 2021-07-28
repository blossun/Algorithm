package dev.solar.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class N1829 {
    boolean[][] visited;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 여러 곳의 시작위치
                if (!visited[i][j] && picture[i][j] != 0) { //방문하지 않았고, 그림이 0(색칠하지 않은 곳)이라면 시작위치로
                    queue.offer(new Point(i, j));
                    numberOfArea++;
                    int curAreaNumber= picture[i][j]; //현재 영역의 숫자
                    int sizeOfOneArea = 0;
                    while (!queue.isEmpty()) {
                        Point curPoint = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = curPoint.x + dx[k];
                            int y = curPoint.y + dy[k];
                            if (x < 0 || x >= m || y < 0 || y >= n) continue; //범위를 벗어났으면
                            if (visited[x][y] || picture[x][y] == 0 || picture[x][y] != curAreaNumber) continue; //이미 방문했거나 0(색칠하지 않는 곳)인 경우
                            queue.offer(new Point(x, y));
                            visited[x][y] = true;
                            sizeOfOneArea++;
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
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
