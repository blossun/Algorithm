package dev.solar.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Prob1 {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = solution.solution(br.readLine());
        System.out.println("answer : " + answer);
        br.close();
    }
}

class Solution {
    public String solution(String new_id) {
        String answer = "";
//        answer = step1(new_id);
//        answer = step2(answer);
//        answer = step3(answer);
//        answer = step4(answer);
//        answer = step5(answer);
//        answer = step6(answer);

        return step7(step6(step5(step4(step3(step2(step1(new_id)))))));
    }

    public String step1(String str) {
        return str.toLowerCase();
    }

    public String step2(String str) {
        String match = "[^0-9a-z-_.]";
        str = str.replaceAll(match, "");
        return str;
    }

    //마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
    public String step3(String str) {
        String[] arrayString = str.split("");
        for (int i = 1; i < arrayString.length; i++) {
            if (arrayString[i].equals(".") && arrayString[i-1].equals(".")) {
                arrayString[i-1] = "";
            }
        }
        return String.join("",arrayString);
    }

    //마침표(.)가 처음이나 끝에 위치한다면 제거
    public String step4(String str) {
        String[] arrayString = str.split("");
        if (Objects.equals(arrayString[0], ".")) {
            arrayString[0] = "";
        }
        if (Objects.equals(arrayString[arrayString.length - 1], ".")) {
            arrayString[arrayString.length - 1] = "";
        }
        return String.join("", arrayString);
    }

    //빈 문자열이라면, new_id에 "a"를 대입
    public String step5(String str) {
        if ("".equals(str)) {
            return "a";
        }
        return str;
    }

    public String step6(String str) {
        if (str.length() > 15) {
            return step4(str.substring(0, 15)); // 문자열 자른 후, 앞뒤 마침표 제거 확인 (step4)
        }
        return str;
    }

    public String step7(String str) {
        int strLength = str.length();
        if (strLength >= 3) {
            return str;
        }
        String[] result = new String[3];
        String[] arrayString = str.split("");
        int i;
        for (i = 0; i < strLength; i++) {
            result[i] = arrayString[i];
        }
        for (int j = 0; j < 3 - strLength; j++) {
            result[strLength + j] = arrayString[strLength - 1];
        }
        return String.join("", result);
    }
}
