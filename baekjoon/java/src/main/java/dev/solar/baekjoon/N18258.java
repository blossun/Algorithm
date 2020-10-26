package dev.solar.baekjoon;

import java.io.*;

public class N18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyQueue queue = new MyQueue();
        int n = Integer.parseInt(br.readLine());
        String[] cmd;
        for (int i = 0; i < n; i++) {
            cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push" :
                    queue.push(Integer.parseInt(cmd[1]));
//                    bw.write(cmd[1]);
                    break;
                case "front" :
                    bw.write(queue.front() + "\n");
                    break;
                case "back" :
                    bw.write(queue.back() + "\n");
                    break;
                case "size" :
                    bw.write(queue.size() + "\n");
                    break;
                case "empty" :
                    bw.write(queue.empty() ? "1\n" : "0\n");
                    break;
                case "pop" :
                    bw.write(queue.pop() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class MyQueue {
        // 원형큐 구현
        // head, tail의 시작은 0으로
        int max = 2000000; //이걸 늘려주니깐 통과함....  이걸 쓸거면 원형 큐 쓰는 의미가 없는 거 아닌가?
        int[] queue = new int[max];
        int head, tail = 0;

        public void push(int x) {
            if (full()) {
                return ;
            }
            tail = (tail + 1) % max;
            queue[tail] = x;
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            head = (head + 1) % max;
            return queue[head];
        }

        public int size() {
            return tail - head;
        }

        // 큐가 비었는지 확인
        public boolean empty() {
            return head == tail;
        }

        // 큐가 꽉 찼는지 확인
        public boolean full() {
            return (tail + 1) % max == head;
        }

        public int front() {
            return empty() ? -1 : queue[(head + 1) % max];
        }

        public int back() {
            return empty() ? -1 : queue[tail];
        }
    }
}

