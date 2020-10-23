package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stock = new Stack<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (!stock.empty()) stock.pop();
            } else {
                stock.push(number);
            }
        }

        int result = 0;
        while (!stock.empty()) {
            result += stock.pop();
        }
        System.out.println(result);
        br.close();
    }
}
