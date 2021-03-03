package dev.solar.codility;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
//        0 ≤ P < Q < R < N
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        //A[P] + A[Q] > A[R] 확인
        for (int i = 0; i < A.length - 2; i++) {
            long P = A[i], Q = A[i + 1], R = A[i + 2];
            if (P + Q > R) {
                return 1;
            }
        }

        return 0;
    }
}
