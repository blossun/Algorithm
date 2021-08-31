package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class N7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String ENTER = "enter";
        final String LEAVE = "leave";
        HashSet<String> attendancrBook = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] log = br.readLine().split(" ");
            if (log[1].equals(ENTER)) {
                attendancrBook.add(log[0]);
            } else if (log[1].equals(LEAVE)) {
                attendancrBook.remove(log[0]);
            }
        }
        List<String> result = attendancrBook.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
