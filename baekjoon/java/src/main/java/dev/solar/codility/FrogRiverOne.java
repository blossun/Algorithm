package dev.solar.codility;

public class FrogRiverOne {
    /* 문제 - 효율성
     * 1 ~ X 까지 각 위치에 등장했는지 여부를 확인하는 X개의 boolean 배열
     * totalSum : 1 ~ X 까지의 총합
     * currentSum : 지금까지 등장한 숫자의 합
     * 이전에 등장하지 않았다면 currentSum에 해당 숫자를 더해줌
     * 이전에 등장했다면 무시
     * totalSum == currentSum이 되는 순간의 초(A배열의 index)를 리턴
    */
    public int solution(int X, int[] A) {
        boolean[] isAppeared = new boolean[X + 1]; //0은 무시. 1부터 시작
        isAppeared[0] = true;
        int totalSum = X * (X + 1) / 2;
        int currentSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (!isAppeared[A[i]]) {
                isAppeared[A[i]] = true;
                currentSum += A[i];
                if (totalSum == currentSum) {
                    return i;
                }
            }
        }
        return -1;
    }
}
