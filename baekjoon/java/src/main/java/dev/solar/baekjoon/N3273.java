package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        boolean exist[] = new boolean[1000002];
        int arr[] = new int[size + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            exist[num] = true;
        }
        int sum = Integer.parseInt(br.readLine());
        System.out.println("sum : " + sum);
        int count = 0;
        for (int i = 0; i < size; i++) {
            int m = sum - arr[i];
            System.out.println("i : " + i + ", arr[i] : " + arr[i] + ", sum - arr[i] : " + m);
            if (m > 1000000 || m < 0 || m == arr[i])
                continue;
            if (exist[m]) {
                System.out.println("exist["+m+"] : true");
                exist[arr[i]] = false;
                count++;
            }
        }
        System.out.println(count);
    }
}
