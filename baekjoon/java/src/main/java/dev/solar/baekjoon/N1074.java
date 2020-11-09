package dev.solar.baekjoon;

import java.util.Scanner;

public class N1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(funcZ(N, r, c));
    }

    private static int funcZ(int n, int r, int c) {
        // Base Condition
        if (n == 0) return 0;

        int kan = (int) Math.pow(2, n);
        int half = (int) Math.pow(2, n - 1);

        if (r < kan / 2 && c < kan / 2) // 1사분면인 경우
            return funcZ(n - 1, r, c);
        if (r < kan / 2 && c >= kan / 2) // 2사분면인 경우
            return half * half + funcZ(n - 1, r, c - half);
        if (r >= kan / 2 && c < kan / 2) // 3사분면인 경우
            return 2 * half * half + funcZ(n - 1, r - half, c);
        // 4사분면인 경우
        return 3 * half * half + funcZ(n - 1, r - half, c - half);
    }
}
