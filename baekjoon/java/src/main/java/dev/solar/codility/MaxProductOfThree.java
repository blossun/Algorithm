package dev.solar.codility;

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] A) {
        // -5, -4, -3, -2, -1 :
        Arrays.sort(A);
        int lastIndex = A.length - 1;
        int answer = A[lastIndex] * A[lastIndex - 1] * A[lastIndex - 2];

        if (A[0] < 0 && A[1] < 0 && A[lastIndex] >= 0) {
            int answer2 = A[0] * A[1] * A[lastIndex];

            if (answer2 > answer) answer = answer2;
        }
        return answer;
    }
}
