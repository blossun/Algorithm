package dev.solar.programmers;

public class N12943 {
    public int solution(int num) {
        int answer = 0;

        while (num != 1) {
            System.out.print(num + " ");
            if (num % 2 == 0) {
                num /= 2 ;
            } else if (num % 2 == 1) {
                num = (num * 3) + 1;
            }
            answer++;
            if (answer == 500) {
                return -1;
                // answer = -1;
                // break;
            }
        }
        return answer;
    }
}
