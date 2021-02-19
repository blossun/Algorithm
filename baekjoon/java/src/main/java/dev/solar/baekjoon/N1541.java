package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int sumOfPlus = 0;
        int sumOfMinus = 0;
        int i = 0;
        int num = 0;
        for (; i < str.length; i++) {
            char ch = str[i];
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                sumOfPlus += num;
                num = 0;
            } else { // '-' 이후부터의 값은 모두 음수로 합해버리기 위해서
                sumOfPlus += num;
                break;
            }
        }
        if (i == str.length) {
            sumOfPlus += num;
        }
        num = 0;
        for (; i < str.length; i++) {
            char ch = str[i];
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
                continue;
            }
            if (ch == '+' || ch == '-') {
                sumOfMinus += num;
                num = 0;
            }
        }
        sumOfMinus += num;
        System.out.println(sumOfPlus - sumOfMinus);
    }
}
