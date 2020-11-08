package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyQueue queue = new MyQueue();
        int n = Integer.parseInt(br.readLine());
        String[] cmd;
        for (int i = 0; i < n; i++) {
            cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push" :
                    queue.push(Integer.parseInt(cmd[1]));
//                    System.out.println(cmd[1]);
                    break;
                case "front" :
                    System.out.println(queue.front());
                    break;
                case "back" :
                    System.out.println(queue.back());
                    break;
                case "size" :
                    System.out.println(queue.size());
                    break;
                case "empty" :
                    System.out.println(queue.empty() ? "1" : "0");
                    break;
                case "pop" :
                    System.out.println(queue.pop());
                    break;
            }
        }

    }

    static class MyQueue {
        // 원형 큐로 구현하지 않고, 최대 입력 수 만큼 큰 배열을 사용해서 구현함. (알고리즘을 위한 큐... 실제로 X)
        // head, tail의 시작은 0으로
        int[] queue = new int[1000005];
        int head, tail = 0;

        public void push(int x) {
            queue[tail++] = x;
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            return queue[head++]; //head값을 출력하고 위치를 이동
        }

        public int size() {
            return tail - head;
        }

        public boolean empty() {
            return tail == head;
        }

        public int front() {
            return empty() ? -1 : queue[head];
        }

        public int back() {
            return empty() ? -1 : queue[tail - 1];
        }
    }
}
