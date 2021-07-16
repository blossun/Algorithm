package dev.solar.programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class N49994Test {

    N49994 n49994 = new N49994();

    @Test
    void case01() {
        String dirs = "LULLLLLLU";
        int expected = 7;
        int actual = n49994.solution(dirs);
        assertEquals(expected, actual);
    }

    @Test
    void case02() {
        String dirs = "LRLRL";
        int expected = 1;
        int actual = n49994.solution(dirs);
        assertEquals(expected, actual);
    }

    @Test
    void temp2() {
        int[] arr1 = new int[]{1, 1};
        int[] arr2 = new int[]{2, 2};
        arr2 = arr1;
        System.out.println(Arrays.toString(arr2));
    }

    @Test
    void temp3() {
        Point point1 = new Point(1, 1, 1, 2);
        Point point2 = new Point(1, 2, 1, 1);
        System.out.println(point1.equals(point2));
        HashSet<Point> isAppeared = new HashSet<>();
        isAppeared.add(point1);
        System.out.println(isAppeared.contains(point2));
    }

    @Test
    void temp() {
        Point point1 = new Point(1, 1, 1, 2);
        Point point2 = new Point(1, 1, 1, 2);
        Point point3 = new Point(2, 1, 1, 2);
        System.out.println(point1.equals(point2));
        System.out.println(point1.equals(point3));
        HashSet<Point> isAppeared = new HashSet<>();
        isAppeared.add(point1);
        System.out.println(isAppeared.contains(point2));
        System.out.println(isAppeared.contains(point3));
    }

    public class Point {
        int x1, y1, x2, y2;

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
                    y2 == point.y2 ||
                    (x1 == point.x2 &&
                            y1 == point.y2 &&
                            x2 == point.x1 &&
                            y2 == point.y1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
}
