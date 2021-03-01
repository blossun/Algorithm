package dev.solar.codility;

import java.util.Arrays;

public class MissingInteger {
    public int solution(int[] A) {
        /* A배열을 sort
         * 음수, 0은 무시
         * 1부터 +1씩한 값을 체크하다가 +1한 값이 아닌 +2이상의 값이 나오는 순간 리턴
         */
        Arrays.sort(A);
        int missingInteger = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) {
                continue;
            } else {
                if (A[i] == missingInteger) {
                    missingInteger++;
                } else if (A[i] < missingInteger) {
                    continue;
                } else {
                    return missingInteger;
                }
            }
        }

        return missingInteger;
    }

}
