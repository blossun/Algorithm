package dev.solar.programmers;

import java.util.Arrays;

public class N12941 {
    public int solution(int[] A, int[] B)
    {
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int length = A.length;
        for (int i = 0; i < length; i++) {
            sum += A[i] * B[length - 1 - i];
        }
        return sum;
    }
}
