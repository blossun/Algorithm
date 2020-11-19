package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N6603 {
    static int N;
    static int M = 6;
    static int[] nums; //수열 대상이 되는 숫자들
    static int[] arr = new int[M]; //뽑힌 수열을 담을 배열 - 로또 6자리
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            if (N == 0)
                break;

            nums = new int[N];
            visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            // 오름차순 정렬
            Arrays.sort(nums);
            sequence(0, 0);
            sb.append('\n');
        }
        System.out.println(sb);

    }

    private static void sequence(int start, int k) { //k번쨰 수 선택, start 부터 탐색
        if (k == 6) { //6개 번호를 다 뽑았다면
            for (int num : arr) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]){
                arr[k] = nums[i];
                visit[i] = true;
                sequence(i + 1, k + 1); //k + 1번쨰 수 탐색하러, start값은 i+1 부터
                visit[i] = false;
            }
        }
    }

}
