package dev.solar.nhn;

import java.util.Stack;

public class n04 {
    public static void main(String[] args) {
//        String cardNumber = "21378"; //valie
//        String cardNumber = "31378"; //invalid
        String cardNumber = "11111101"; //valid
        System.out.println(solution(cardNumber));
    }

    private static String solution(String cardStr) {
        boolean result;
        char[] cardCh = cardStr.toCharArray();
        int[] cardNumber = new int[cardCh.length];
        for (int i = 0; i < cardCh.length; i++) {
            cardNumber[i] = cardCh[i] - '0';
        }

        if (cardCh.length % 2 == 0)
            result = evenFunc(cardNumber);
        else
            result = oddFunc(cardNumber);

        return (result) ? "VALID" : "INVALID";
    }

    private static boolean oddFunc(int[] cardNumber) {
        for (int i = 0; i < cardNumber.length; i++) {
            if (i % 2 != 0)
                cardNumber[i] *= 2;
        }

        return isValid(cardNumber);
    }

    private static boolean evenFunc(int[] cardNumber) { //짝수개 숫자면 홀수 위치 숫자 * 2
        for (int i = 0; i < cardNumber.length; i++) {
            if (i % 2 == 0)
                cardNumber[i] *= 2;
        }

        return isValid(cardNumber);
    }

    private static boolean isValid(int[] cardNumber) {
        int total = 0;
        for (int num : cardNumber) {
            if (num < 10) //한자리 수면 바로 더하기
                total += num;
            else {
                total += sumDigit(num);
            }
        }

        return (total % 10 == 0);
    }

    private static int sumDigit(int num) { // 각 자릿수를 더한 값을 return
        Stack<Integer> disits = new Stack<>();
        while (num / 10 != 0) {
            disits.add(num % 10);
            num /= 10;
        }
        int result = num;
        while (!disits.isEmpty()) {
            result += disits.pop();
        }

        return result;
    }
}
