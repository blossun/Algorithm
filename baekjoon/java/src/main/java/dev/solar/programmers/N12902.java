package dev.solar.programmers;

public class N12902 {
    public long solution(int n) {
        final int MOD = 1000000007;

        int end = n / 2;
        long[] arr = new long[end + 1];
        arr[0] = 0;
        arr[1] = 3;
        for (int i = 2; i <= end; i++) {
            arr[i] = 3 * arr[i - 1];
            for (int j = i - 2; j >= 1 ; j--) {
                arr[i] += 2 * arr[j];
            }
            arr[i] = (arr[i] + 2) % MOD;
        }
        return arr[end];
    }
}
