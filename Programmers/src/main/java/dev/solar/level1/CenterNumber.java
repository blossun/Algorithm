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
/*
* length : 입력받은 문자열의 길이
middle : 문자열의 가운데 위치 인덱스 값을 구함
check : 문자열의 길이가 짝수인지 확인하기 위해 2로 나눈 나머지 값을 저장
조건 - 짝수이면 중간위치보다 하나 더 앞부터 중간위치 값까지만 substring으로 잘라내서 저장
홀수이면 중간위치값만 잘라서 남김*/
