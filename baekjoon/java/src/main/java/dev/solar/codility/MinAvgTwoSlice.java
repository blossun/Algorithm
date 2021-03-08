package dev.solar.codility;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        int minIndex = 0;
        float minAvg = (A[0] + A[1]) / 2f;
        for (int i = 2; i < A.length; i++) {
            float avg = (A[i - 2] + A[i - 1] + A[i]) / 3f;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = i - 2;
            }

            avg = (A[i -1] + A[i]) / 2f;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = i - 1;
            }
        }
        return minIndex;
    }
}
