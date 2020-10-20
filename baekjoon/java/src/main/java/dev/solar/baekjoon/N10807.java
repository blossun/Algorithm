package dev.solar.baekjoon;

import java.util.Scanner;

public class N10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        int findNum = sc.nextInt();
        int count = 0;
        for (int num : nums) {
            if (num == findNum) {
                count++;
            }
        }
        System.out.println(count);
    }
}
