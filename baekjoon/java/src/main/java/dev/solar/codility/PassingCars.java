package dev.solar.codility;

public class PassingCars {
    public int solution(int[] A) {
        int count = 0;
        int total = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                count++;
            } else {
                total += count;
                if (total > 1000000000) {
                    return -1;
                }
            }
        }
        return total;
    }
}
