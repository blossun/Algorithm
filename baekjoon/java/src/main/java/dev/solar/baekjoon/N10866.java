package dev.solar.baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class N10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        String[] command;
        for (int i = 0; i < n; i++) {
            command = br.readLine().split(" ");
            switch (command[0]) {
                case "push_front" :
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                case "push_back" :
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                case "pop_front" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.removeLast() + "\n");
                    break;
                case "pop_back" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.removeFirst() + "\n");
                    break;
                case "size" :
                    bw.write(deque.size() + "\n");
                    break;
                case "empty" :
                    bw.write(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.getLast() + "\n");
                    break;
                case "back" :
                    bw.write(deque.isEmpty() ? "-1\n" : deque.getFirst() + "\n");
                    break;

            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
