package dev.solar.baekjoon;

import java.util.Scanner;

public class N1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    public static int solution(int n) {
        int[] arr = new int[n + 3];
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i < n + 1; i++) {
            int cnt = -1;
            if (i % 6 == 0) cnt = Math.min(arr[(i / 2)], arr[i / 3]) + 1; //공배수인 경우 2와 3으로 나눈 결과중 더 적은 값으로
            else if (i % 2 == 0) cnt = arr[(i / 2)] + 1;
            else if (i % 3 == 0) cnt = arr[(i / 3)] + 1;
            if (cnt == -1) cnt =  arr[(i - 1)] + 1; // 2와 3으로 구할 수 없는 경우
            else cnt = Math.min(cnt, arr[(i - 1)] + 1); //-1을 해서 구햔 경우가 더 적을 수 있으므로 체크 필요
            arr[i] = cnt;
    }
//        for (int i = 0; i < n; i++) {
//            System.out.println("i : " + i + "-> " + arr[i] + " ");
//        }
        return arr[n];
    }
}
