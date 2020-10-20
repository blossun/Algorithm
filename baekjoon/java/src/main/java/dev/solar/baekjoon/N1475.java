package dev.solar.baekjoon;

import java.util.Arrays;
        import java.util.Scanner;

public class N1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int total = 0;
        int[] cardSet = new int[10];
        for (int number : numbers) {
            cardSet[number]++;
        }
        // 6과 9 때문에 필요한 셋트 수를 먼저 계산해서 total에 저장
        total = (int) Math.round((double) (cardSet[6] + cardSet[9]) / 2); //5개변 3개가 필요
        // 6과 9는 계산했으니깐 초기
        cardSet[6] = 0;
        cardSet[9] = 0;
        // 더 많이 필요한 숫자가 있는 경우 해당 숫자의 갯수가 필요한 셋트 수가 된다.
        int temp = Arrays.stream(cardSet).max().getAsInt();
        if (temp > total) {
            total = temp;
        }
        System.out.println(total);
    }
}

/*
10 size의 배열 : 한 셋트 0 ~ 9
숫자 배열 입력받아서 해당 번호의 인덱스 값 +1
이미 값이 1인 경우 새로운 셋트 추가 -> X
but, 6이거나 9인 경우 서로의 값도 확인 -> X
6이면 6값을 +1 계속하기
9이면 9값을 +1 계속하기
최종적으로 6과 9의 갯수를 더해서 /2 한 값이 (6과 9의 )필요한 셋트 수 가 된다.
각 인덱스의 값이 가장 높은 값 = 필요한 셋트 수 (6과 9는 별도로 계산)
 */
