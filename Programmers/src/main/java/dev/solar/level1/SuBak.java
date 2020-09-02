package dev.solar.level1;

public class SuBak {
    public String solution(int n) {
        String answer = "";
        String A = "수";
        String B = "박";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                sb.append(A);
            } else {
                sb.append(B);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
/*
* 입력받은 n만큼 for문을 돌면서 0과 짝수 자리에 더해질 문자와 홀수 자리에 더해질 문자를 분기문으로 나눠서 문자열 생성*/
