package dev.solar.codingtest;

import java.util.Arrays;

public class Woowa04 {
    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        ;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
//            if (i < m - 1 && (B[i] == B[i + 1] || B[i] < A[k]))
//                i += 1;
            if (i < m - 1 && B[i] < A[k]) {
                i += 1;
                k = 0;
            }
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}
