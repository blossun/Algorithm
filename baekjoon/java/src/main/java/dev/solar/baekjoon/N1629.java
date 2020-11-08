package dev.solar.baekjoon;

import java.util.Scanner;

public class N1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(recursiveMod(a, b, c));
    }

    public static long recursiveMod(long a, long b, long c) {
        // Base Condition
        // 지수가 1이면 종료
        if (b == 1) {
            return a % c;
        }

        long value = recursiveMod(a, b / 2, c);
        value = value * value % c;
        if (b % 2 == 0) return value;
        return value * a % c; //y == 1 인 경우
    }

}
