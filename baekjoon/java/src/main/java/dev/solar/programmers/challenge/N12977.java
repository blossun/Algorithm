package dev.solar.programmers.challenge;

public class N12977 {
    static int N;
    static int M = 3;
    static int[] arr = new int[3];
    static boolean[] isUsed = new boolean[52]; //nums 숫자 갯수 : 3 ~ 50
    static int countOfPrimeNumber = 0;

    public int solution(int[] nums) {
        N = nums.length;
        backTracking(0, 0, nums);

        return countOfPrimeNumber;
    }

    private static void backTracking(int k, int start, int[] nums) { // 현재 k개수까지 수를 선택
        if (k == M) { //3개를 다 뽑았으면 확인
            if (isPrime(arr[0] + arr[1] + arr[2])) {
                countOfPrimeNumber++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!isUsed[i]) {
                arr[k] = nums[i];
                isUsed[i] = true;
                backTracking(k + 1, i + 1, nums);
                isUsed[i] = false;
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number == 1 || number < 0) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
