package dev.solar.codingtest;

import java.util.Arrays;

public class Woowa03 {
    public int solution(int[] A) {

        // A의 갯수가 1개 이하인 경우 값이 존재하지 않음
        if (A.length <= 1) {
            return 0;
        }

        Arrays.sort(A);
        int leftIndex = 0;
        int rightIndex = A.length - 1;
        int result = 0;

        while (leftIndex < A.length && rightIndex >= 0) {
            int left = A[leftIndex];
            int right = A[rightIndex];
            if (isEqualSign(left, right)) {
                break;
            }
            if (isOpposite(left, right)) { //해를 찾은 경우
                result = right;
                break;
            }
            // 비교할 인덱스 이동
            if (Math.abs(left) > right) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return result;
    }

    private boolean isEqualSign(final int left, final int right) {
        if (left < 0 && right < 0) {
            return true;
        }
        if (left > 0 && right > 0) {
            return true;
        }
        return false;
    }

    private boolean isOpposite(final int left, final int right) {
        return right * -1 == left;
    }
}
