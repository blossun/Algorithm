package dev.solar.codility;

public class TapeEquilibrium {
    public int solution(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int totalSum = prefixSum[prefixSum.length - 1]; //모든 합

        int minDifference = 100001; //나올 수 있는 차의 최고값보다 높게 설정
        // 0 < P < N
        for (int i = 0; i < arr.length - 1; i++) { // arr.length - 1 범위보다 작은 경우까지만 확인해야함
            minDifference = Math.min(minDifference, Math.abs(totalSum - prefixSum[i] * 2));
        }

        return minDifference;
    }
}
