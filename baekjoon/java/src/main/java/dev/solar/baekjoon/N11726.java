package dev.solar.baekjoon;

import java.util.Scanner;

public class N11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    public static int solution(int n) {
        int mod = 10007;
        int[] arr = new int[n + 3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % mod; // 계산하는 중간중간 나머지를 취하지 않고 끝나고 나누게 되면 int overflow로 인해 오답이 발생
        }
        return arr[n];
    }
}
