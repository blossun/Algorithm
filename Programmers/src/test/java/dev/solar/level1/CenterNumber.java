package dev.solar.level1;

public class CenterNumber {
    public static void main(String[] args) {
        System.out.println(solution("qwer"));
        System.out.println(solution("qbcde"));
    }

    public static String solution(String s) {
        String answer = "";
        int length = s.length();
        int check = length % 2;
        int middle = length / 2;
        System.out.println(check);
        if (check == 0) {
            answer = s.substring(middle - 1, middle + 1);
        } else {
            answer = s.substring(middle, middle + 1);
        }
        return answer;
    }
}
