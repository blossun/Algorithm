package dev.solar.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class N10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyStack myStack = new MyStack();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmdLine = br.readLine().split(" ");
            String cmd = cmdLine[0];
            if (cmd.equals("push")) {
                myStack.push(Integer.parseInt(cmdLine[1]));
            } else if (cmd.equals("top")) {
                if (!myStack.empty()) {
                    bw.write(myStack.top() + "\n");
                } else {
                    bw.write("-1" + "\n");
                }
            } else if (cmd.equals("size")) {
                bw.write(myStack.size() + "\n");
            } else if (cmd.equals("pop")) {
                if (!myStack.empty()) {
                    bw.write(myStack.pop() + "\n");
                } else {
                    bw.write("-1" + "\n");
                }
            } else if (cmd.equals("empty")) {
                bw.write(myStack.empty() ? "1" : "0" + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class MyStack {
        // 연결리스트로 스택 구현
        private List<Integer> stock = new ArrayList<>();
        private int top;

        public MyStack() {
            this.top = -1;
        }

        public void push(int value) {
            stock.add(value);
            top++;
        }

        public int pop() {
            int result = stock.get(top);
            stock.remove(top);
            top--;
            return result;
        }

        public int size() {
            return stock.size();
        }

        public boolean empty() {
            return stock.isEmpty();
        }

        public int top() {
            return stock.get(top);
        }

        public List<Integer> getStock() {
            return stock;
        }
    }
}
