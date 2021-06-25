package dev.solar.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class N42839 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] isUsed;
    static int count = 0;
    // {0,1,1}로 순열을 만들 경우, 110이 두 번 나올 수 있다.
    // 중복 계산되지 않도록 HashSet으로 이전에 나온값이면 skip하도록 한다.
    static HashSet<Integer> isAppeared = new HashSet<>();

    public int solution(String numbers) {
        // numbers를 한자리 수로 분리해서 배열로 변환
        // n개의 수에서  0 ~ n개의 수를 뽑아서 만들 수 있는 순열을 구한다. -> 백트래킹
        // 각 수마다 소수인지를 확인해서 count++
        // ex) "011" -> {0, 1, 1} -> {0, 1, 1, 01, 01, 11, ... 011, 101, 110}
        int[] numbersArray = Arrays.stream(numbers.chars().toArray()).map(i -> i - '0').toArray();
        N = numbersArray.length;
        for (int i = 1; i <= N; i++) { // 0 ~ M 자리의 숫자
            M = i;
            arr = new int[M]; // M개의 숫자를 뽑아서 순열을 만듦
            isUsed = new boolean[N];

            backTracking(0, numbersArray);
        }

        return count;
    }

    private void backTracking(int k, int[] numbersArray) { //N개의 숫자가 들어있는 numbersArray배열에서 M개의 숫자를 뽑아서 완성
        if (k == M) {
            // int[] -> 하나의 숫자로 완성
            int num = 0;
            for (int n : arr) {
                num = num * 10 + n;
            }
            if (!isAppeared.contains(num) && isPrime(num)) { //이전에 등장한 숫자가 아니고, 소수이면
                count++;
                isAppeared.add(num);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                arr[k] = numbersArray[i];
                isUsed[i] = true;
                backTracking(k + 1, numbersArray);
                isUsed[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number == 1 || number == 0) {
            return false;
        }

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
