package dev.solar.codingtest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ChannelTalk02 {
    int[][] digit;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int X;
    int Y;

    public int solution(int[][] cars) {
        Y = cars.length;
        X = cars[0].length;
        digit = new int[Y][X];
        int result = -1;
        for (int i = 0; i < Y; i++) {
            Arrays.fill(digit[i], -1);
        }
        PriorityQueue<Point> queue = new PriorityQueue<>();
        // 민수 자동차 위치
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (cars[y][x] == 1) {
                    queue.offer(new Point(x, y, 0));
                    digit[x][y] = 0;
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (x < 0 || x >= X || y < 0 || y >= Y) continue;
                if (digit[x][y] != -1 || cars[y][x] == 3) continue; //이미 지나갔거나 검은차인 경우
                if (cars[y][x] == 4) {
//                    if (result == -1) {
//                        result = digit[cur.x][cur.y];
//                        digit[x][y] = result;
//                    } else {
//                        result = Math.min(result, digit[cur.x][cur.y]);
//                        digit[x][y] = result;
//                    }
                    return digit[cur.x][cur.y];
                }

                if (cars[y][x] == 2) {
                    digit[x][y] = digit[cur.x][cur.y] + 1;
                } else {
                    digit[x][y] = digit[cur.x][cur.y];
                }

//                int move = (cars[x][y] == 2) ? 1 : 0;
//                int curMoveCount = digit[cur.x][cur.y] + move;
//                if (digit[x][y] == -1) {
//                    digit[x][y] = curMoveCount;
//                } else {
//                    digit[x][y] = Math.min(digit[x][y], curMoveCount);
//                }
                queue.offer(new Point(x, y, digit[x][y]));
            }
        }

        return result;
    }

    class Point implements Comparable<Point> {
        int x;
        int y;
        int n;

        public Point(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

        @Override
        public int compareTo(Point o) {
            return this.n - o.n;
        }
    }
}
