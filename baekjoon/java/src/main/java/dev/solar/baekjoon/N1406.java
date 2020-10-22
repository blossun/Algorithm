package dev.solar.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N1406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> text = new ArrayList<>(); //문자열 -> char 배열 -> List
        char[] charText = sc.nextLine().toCharArray();
        for (char c : charText) {
            text.add(String.valueOf(c));
        }
        int m = sc.nextInt();
        int index = text.size();
        String cmd;
        for (int i = 0; i < m; i++) {
            cmd = sc.next();
            if (cmd.equals("P")) {
                text.add(index, sc.next());
                index++;
            } else if (cmd.equals("L")) {
                if (index != 0) {
                    index--;
                }
            } else if (cmd.equals("D")) {
                if (index < text.size()) {
                    index++;
                }
            } else if (cmd.equals("B")) {
                if (index != 0) {
                    index--;
                    text.remove(index);
                }
            }
        }
//        StringBuilder sb = new StringBuilder();
//        for (String s : text) {
//            sb.append(s);
//        }
//        System.out.println(sb);
        String result = text.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
        System.out.println(result);
    }
}
