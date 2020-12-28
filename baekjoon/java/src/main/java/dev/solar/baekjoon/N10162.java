package dev.solar.baekjoon;

import java.util.Scanner;

public class N10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] count = new int[3];
        int[] timer = {300, 60, 10};
        while (true) {
            if (T >= 300) {
                T -= 300;
                count[0]++;
            } else if (T >= 60) {
                T -= 60;
                count[1]++;
            } else if (T >= 10) {
                T -= 10;
                count[2]++;
            } else if (T == 0) {
                System.out.println(count[0] + " " + count[1] + " " + count[2]);
                break;
            } else {
                System.out.println("-1");
                break;
            }
        }
    }
}
