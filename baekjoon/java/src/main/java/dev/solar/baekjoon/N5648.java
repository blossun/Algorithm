package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Long> nums = new ArrayList<>();
        while (N > 0) {
            if (st.hasMoreTokens()) {
                N -= 1;
                long num = Long.parseLong(st.nextToken());
                 long reversed = 0;
                while (num != 0) {
                    long digit = num % 10;
                    reversed = reversed * 10 + digit;
                    num /= 10;
                }
                nums.add(reversed);
            } else {
                st = new StringTokenizer(br.readLine());
            }
        }
        Collections.sort(nums);
        Iterator<Long> it = nums.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append('\n');
        }
        System.out.println(sb);
    }
}
