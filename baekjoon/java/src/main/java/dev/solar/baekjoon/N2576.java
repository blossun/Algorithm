package dev.solar.baekjoon;

import java.util.Scanner;

public class N2576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 100;
        int num;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            num = sc.nextInt();
            if (num % 2 != 0) {
                sum += num;
                if (num < min) {
                    min = num;
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
            return ;
        }
        System.out.println(sum + "\n" + min);
    }
}
