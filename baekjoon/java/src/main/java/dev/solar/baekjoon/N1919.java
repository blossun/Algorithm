package dev.solar.baekjoon;

import java.util.Scanner;

public class N1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] first = sc.nextLine().toCharArray();
        char[] second = sc.nextLine().toCharArray();
        int[] alpha = new int[26];
        int total = 0;
        for (char c : first) { //첫 문자열의 알파벳 갯수 파악
            alpha[(int) c - 'a']++;
        }
        for (char c : second) { //해당하는 문자 -1
            alpha[(int) c - 'a']--;
        }
        for (int i : alpha) {
            if (i >= 0) {
                total += i;
            } else {
                total += i * -1;
            }
        }
        System.out.println(total);
    }
}

/*
첫 문자열을 char 배열에 저장 (아스키코드 값으로 a -> 0, b -> 1)
두번째 문자열을 char 배열로 만들어서 하나하나 해당 문자를 -1 씩 지워나감
최종적으로
지워야할 문자 수 : 첫 문자 배열에 남아있는 문자 갯수 + 두 번째 문자배열에 남아있는 문자 갯수
즉, alpha 양수 갯수 + alpha 음수의 절댓값 갯수
 */
