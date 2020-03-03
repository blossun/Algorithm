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
