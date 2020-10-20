package dev.solar.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solv(numbers));
    }

    public static int solv(int[] numbers) {
        Arrays.sort(numbers);
        int max = numbers[2];
        if (max == numbers[0]) {
            return 10000 + max * 1000;
        }
        if (max == numbers[1]) {
            return 1000 + max * 100;
        }
        max = numbers[1];
        if (max == numbers[0]) {
            return 1000 + max * 100;
        }
        return numbers[2] * 100;
    }
}

/*
3수를 입력 받아 정렬하고,
1. 마지막 수가 첫 수랑 같다면 -> 세 수가 같음 : (1, 2, 3)
2. 마지막 수가 두번째 수랑 같다면 -> 두 수가 같음 : 1, (2, 3)
3. 두번째 수가 첫 수랑 같다면 -> 두 수가 같음 : (1, 2), 3
4. 모두 다른 경우 이므로 -> 마지막 수가 제일 큰 수 : 1, 2, 3
 */
