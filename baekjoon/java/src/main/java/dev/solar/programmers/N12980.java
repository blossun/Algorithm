package dev.solar.programmers;

public class N12980 {
    public int solution(int n) {
        int power = 0;
        while (n > 0) {
            if (n%2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                power++;
            }
        }
        return power;
    }



    /**
     * dp로 풀이
     * 정확도는 100이지만 효율성이 0
     * @param n
     * @return
     */
    public int solution01(int n) {
        int[] disit = new int[n + 1];
        disit[0] = 0;
        disit[1] = 1;
        for (int i = 2; i <= n; i++) {
            // i가 짝수인 경우, i/2에서 점프 했을 때와 비교
            if (i % 2 == 0) {
                if (disit[i / 2] <= disit[i - 1]) {
                    disit[i] = disit[i / 2];
                    continue;
                }
            }
            disit[i] = disit[i - 1] + 1;
        }
        return disit[n];
    }
}
