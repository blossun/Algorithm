package dev.solar.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N2752 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }
}
