package dev.solar.baekjoon;

import java.util.Scanner;

public class N11328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            char[] first = sc.next().toCharArray();
            char[] second = sc.next().toCharArray();
            if (isPossible(first, second)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    public static boolean isPossible(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }
        int[] alpha = new int[26];
        for (char c : first) {
            alpha[(int)c - 'a']++;
        }
        for (char c : second) {
            if (alpha[(int)c - 'a'] == 0) { //만드려는 문자가 부족한 경우
                return false;
            }
            alpha[(int)c - 'a']--;
        }
        for (int i : alpha) { //알파벳이 남아있는 경우
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

/*
첫번째 문자열의 각 자리별로 알파벳 배열에 해당하는 각 인덱스값을 +1
두번째 문자열의 각 자리별로 알파벳 배열을 확인
알파벳 해당 자리의 값이 0이면 바로 Impossible
모든 알파벳이 존재한 경우, 알파벳 배열에 남아있는 알파벳이 있다면 Impossible
 */
