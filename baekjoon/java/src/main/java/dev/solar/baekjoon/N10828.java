package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyStack myStack = new MyStack();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmdLine = br.readLine().split(" ");
            String cmd = cmdLine[0];
            if (cmd.equals("push")) {
                myStack.push(Integer.parseInt(cmdLine[1]));
            } else if (cmd.equals("top")) {
                if (!myStack.empty()) {
                    System.out.println(myStack.top());
                } else {
                    System.out.println("-1");
                }
            } else if (cmd.equals("size")) {
                System.out.println(myStack.size());
            } else if (cmd.equals("pop")) {
                if (!myStack.empty()) {
                    System.out.println(myStack.pop());
                } else {
                    System.out.println("-1");
                }
            } else if (cmd.equals("empty")) {
                System.out.println(myStack.empty() ? "1" : "0");
            }
        }

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
