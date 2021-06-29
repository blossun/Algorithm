package dev.solar.programmers;

public class N12924 {
    public int solution(int n) {
        int answer = 1;
        int mid = (n % 2 == 0) ? n / 2 : n / 2 + 1;
        for (int i = mid; i > 0 ; i--) {
            int sum = i;
            for (int j = i - 1; j > 0 ; j--) {
                sum += j;
                if (sum > n) {
                    break;
                }
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
