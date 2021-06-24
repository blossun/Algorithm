package dev.solar.programmers;

import java.util.Arrays;

public class N12945 {
    double[] fibo_memo;
    public int solution(int n) {
        /**
         * 동적 알고리즘 O(n^2)
         */
//        fibo_memo = new double[n + 2];
//        Arrays.fill(fibo_memo, -1);
//        fibo_memo[0] = 0;
//        fibo_memo[1] = 1;
//        return fibo_dynamic(n);
        // end of fibo_dynamic

//        return fibo_recursion(n);
        return filbo_while_divided(n);
    }

    private int filbo_while_divided(int n) { //문제
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] % 1234567) + (fibo[i - 2] % 1234567);
        }
        return fibo[n] % 1234567;
    }

    private double filbo_while(int n) { //반복 O(n) - 공간복잡도 : n
        double[] fibo = new double[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n];
    }

    private double fibo_recursion(int n) { //재귀 O(n^2)
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibo_recursion(n - 1) + fibo_recursion(n - 2);
    }

    private double fibo_dynamic(int n) { //동적 O(n^2)
        if (fibo_memo[n] != -1) {
            return fibo_memo[n];
        }
        fibo_memo[n] = fibo_dynamic(n - 1) + fibo_dynamic(n - 2);
        return fibo_memo[n];
    }
}
