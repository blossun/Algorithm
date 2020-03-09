package dev.solar.level1;

public class CalculateGCDandLCM {
    public int[] solution(int n, int m) {
        int gcd = 1;
        int minNum = Math.min(n, m);
        for (int i = 1; i < minNum+1; i++) {
            if (n%i == 0 && m%i == 0) {
                gcd*=i;
                n = n/i;
                m = m/i;
                minNum = minNum/i;
                i = 1;
            }
        }
        int lcm = gcd * n * m;
        int[] answer = {gcd, lcm};
        return answer;
    }
}
// 재귀로 변환 가능
