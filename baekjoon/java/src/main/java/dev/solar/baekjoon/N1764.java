package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class N1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        List<String> result = new LinkedList<>(); //듣도보도 못한사람
        HashSet<String> notHear = new HashSet<>();
        for (int i = 0; i < n; i++) {
            notHear.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String person = br.readLine();
            if (notHear.contains(person)) {
                result.add(person);
            }
        }
        System.out.println(result.size());
        result.stream().sorted().forEach(System.out::println);
    }
}
