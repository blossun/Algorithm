package dev.solar.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N12953 {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }
    public int solution_fail02(int[] arr) {
        Arrays.sort(arr);
        List<Integer> elements = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            if (n == 1) {
                continue;
            }
            boolean isAdded = false;
            for (Integer element : elements) {
                if (n % element == 0) {
                    n /= element;
                }
            }
            if (!isAdded) {
                elements.add(n);
            }
        }

        int answer = 1;
        for (Integer element : elements) {
            answer *= element;
        }
        return answer;
    }

    public int solution_fail(int[] arr) {
        // 오름차순 정렬
        // 앞에서부터 하나씩 배수배열을 담는다.
        Arrays.sort(arr);
        List<Integer> elements = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                continue;
            }
            elements.add(arr[i]);
            if (i + 1 == arr.length) {
                break;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] % arr[i] == 0) {
                    arr[j] /= arr[i];
                }
            }
        }
        int answer = 1;
        for (Integer element : elements) {
            answer *= element;
        }
        return answer;
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return ((a * b) / gcd(a, b));
    }
}
