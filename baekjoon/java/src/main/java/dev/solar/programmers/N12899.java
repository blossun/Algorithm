package dev.solar.programmers;

public class N12899 {
    public String solution(int n) {
        int[] digit = {1, 2, 4};
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n -= 1;
            int remain = n % 3;
            n /= 3;
            sb.append(digit[remain]);
        }
        String answer = sb.reverse().toString();
        return answer;
    }
}
