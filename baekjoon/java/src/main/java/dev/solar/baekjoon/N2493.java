package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> arr = new Stack();
        Stack<Integer> tmp = new Stack();
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.push(Integer.parseInt(st.nextToken()));
        }
        int number = arr.pop();
        while (count != N) { //arr.isEmpty()로 조건을 주면 안됨
            if (arr.isEmpty()) {
                count++;
                sb.append("0 ");
                while (!tmp.isEmpty()) {
                    arr.push(tmp.pop());
                }
            }
            int topValue = arr.pop();
//            System.out.println("number : " + number + ", topValue : " + topValue);
            if (number < topValue) {
                count++;
                sb.append(arr.size() + 1).append(" ");
                arr.push(topValue);
                while (!tmp.empty()) { // 중간에 더 작았던 탑이 있다면
                    arr.push(tmp.pop()); //뺏던 값을 다시 넣어준다.
                }
                number = arr.pop();
//                System.out.println(Arrays.toString(arr.toArray()));
            } else {
                tmp.push(topValue);
            }
        }
        System.out.println(sb.reverse());
    }
}
