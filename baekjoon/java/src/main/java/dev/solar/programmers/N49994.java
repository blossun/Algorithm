package dev.solar.programmers;

import java.util.*;

public class N49994 {
    // U, D, R, L
    private HashMap<Character, Integer> dirMap = new HashMap<>();
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public int solution(String dirs) {
        dirMap.put('U', 0);
        dirMap.put('D', 1);
        dirMap.put('R', 2);
        dirMap.put('L', 3);
        int answer = 0;
        // 지나간 길인지 체크 (지점이 아니라 길을 확인해야 한다.)
        HashSet<Point> visited = new HashSet<>();
        int x = 0, y = 0;
        char[] chars = dirs.toCharArray();
        for (char dir : chars) {
            Integer idx = dirMap.get(dir);
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            Point newPoint = new Point(x, y, nx, ny);
            if (!visited.contains(newPoint)) {
                visited.add(newPoint);
                visited.add(new Point(nx, ny, x, y)); //길은 양방향으로 체크해야 한다.
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }

    class Point {
        private int x1, y1, x2, y2;

        public Point(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x1 == point.x1 &&
                    y1 == point.y1 &&
                    x2 == point.x2 &&
                    y2 == point.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
}
