package dev.solar.baekjoon;

import java.util.Scanner;

public class N14956 {
    static int N;
    static int M;
    static Point cur;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cur = walk(N, M - 1);
        System.out.println(cur.x + " " + cur.y);
    }

    private static Point walk(int n, int m) {
//        System.out.println("n : " + n + ", m : " + m);
        //Base Condition 최소 문양
        if (n ==2) { // 발검음 수에 해당하는 좌표를 반환
            switch (m) { //m으로 걸음 수 구분할 때, 0,1,2,3 으로 해야 함. (1,2,3,4)로 해서 틀림
                case 0:
                    return new Point(1, 1);
                case 1:
                    return new Point(1, 2);
                case 2:
                    return new Point(2, 2);
                default:
                    return new Point(2, 1);
            }
        }

        // 4분할해서 몇 사분면에 해당하는지 확인 후, 이전(n/2) 모양에서의 좌표를 구해옴
        int half = n / 2;
        int quadrant = m / (half * half); //사분면
        // 이전(n/2) 값의 모양의 좌표값을 가져옴
        Point pre = walk(half, m % (half * half));
        switch (quadrant) {
            case 0:
                return new Point(pre.y, pre.x);
            case 1:
                return new Point(pre.x, pre.y + half);
            case 2:
                return new Point(pre.x + half, pre.y + half);
            default:
                return new Point(half * 2 - pre.y + 1, half - pre.x + 1);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*
board를 그리지 않고, 이전 미로의 좌표값을 가져와 계속해서 다음 미로의 좌표값을 계산해가서 return
 */
