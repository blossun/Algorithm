package dev.solar.naver;

import java.util.Stack;

public class Test5 {
    public int solution(int N) {
        Stack<Integer> leftDigits = new Stack<>();
        Stack<Integer> rightDigits = new Stack<>();
        boolean isNegative = false;
        if (N == 0) {
            leftDigits.push(N);
        }
        if (N < 0) {
            isNegative = true;
            N *= -1;
        }
        int digit = 10;
        while (N > 0) {
            int numDigit = N % digit;
            N /= digit;
            leftDigits.push(numDigit);
        }

        if (isNegative) {
            return calculateNegative(leftDigits, rightDigits);
        }
        return calculatePositive(leftDigits, rightDigits);
    }

    private int calculateNegative(Stack<Integer> leftDigits, Stack<Integer> rightDigits) {
        int digit;
        while (!leftDigits.isEmpty()) {
            if (leftDigits.peek() > 5) {
                break;
            }
            rightDigits.push(leftDigits.pop());
        }
        leftDigits.push(5);

        while (!leftDigits.isEmpty()) {
            rightDigits.push(leftDigits.pop());
        }

        int result = 0;
        digit = 1;
        while (!rightDigits.isEmpty()) {
            result += rightDigits.pop() * digit;
            digit *= 10;
        }
        return result * -1;
    }

    private int calculatePositive(Stack<Integer> leftDigits, Stack<Integer> rightDigits) {
        int digit;
        while (!leftDigits.isEmpty()) {
            if (leftDigits.peek() < 5) {
                break;
            }
            rightDigits.push(leftDigits.pop());
        }
        leftDigits.push(5);

        while (!leftDigits.isEmpty()) {
            rightDigits.push(leftDigits.pop());
        }

        int result = 0;
        digit = 1;
        while (!rightDigits.isEmpty()) {
            result += rightDigits.pop() * digit;
            digit *= 10;
        }
        return result;
    }
}
