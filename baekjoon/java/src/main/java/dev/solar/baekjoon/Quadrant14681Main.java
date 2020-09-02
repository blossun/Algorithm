package dev.solar.baekjoon;

// 좌표 (x, y)가 속하는 사분면 구하기
import java.util.*;

class Quadrant_14681 {
    int quadrant(int x, int y) {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x > 0 && y < 0) {
            return 4;
        } else if (x < 0 && y > 0) {
            return 2;
        } else {
            return 3;
        }
    }
}

public class Quadrant14681Main {
    public static void main(String[] args) {
        Quadrant_14681 quadrant_14681 = new Quadrant_14681();

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int result = quadrant_14681.quadrant(x, y);
        System.out.println(result);
    }
}
