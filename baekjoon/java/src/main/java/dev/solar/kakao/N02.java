package dev.solar.kakao;

import java.util.Objects;

public class N02 {
    public int solution(int n, int k) {
        String numberStr = convertNumber(n, k);
        String[] numberList = String.valueOf(numberStr).split("0");
        int answer = 0;
        for (String s : numberList) {
            System.out.println(s);
            if (!Objects.isNull(s) && !s.isEmpty()) {
                if (isPrime(Integer.parseInt(s))) {
                    answer++;
                }
            }
        }
        return answer;
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

    public String convertNumber(int number, int n) {
        StringBuilder sb = new StringBuilder();
        int current = number;

        // 진법 변환을 할 숫자가 0보다 큰 경우까지 진행
        while (current > 0) {
            int remain = current % n;
            if (remain < 10) { // 0 ~ 9 사이의 값은 그대로 넣으면 된다.
                sb.append(remain);
            } else {
                sb.append((char) (remain - 10 + 'A')); //10부터는 A이후 문자로 표시된다.
            }
            current /= n;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        N02 n02 = new N02();
        int result = n02.solution(437674, 3);
        System.out.println("result : " + result);
        int n = 110011;

    }
}
