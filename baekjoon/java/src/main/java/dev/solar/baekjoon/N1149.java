package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][3]; //[0]: R, [1]: G, [2]: B

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(arr, N));
    }

    public static int solution(int[][] arr, int n) {
        int[][] cost = new int[n][3];

        // 첫번째 집 비용 계산
        for (int i = 0; i < 3; i++) { //색은 무조건 3가지 색생임!! n번 돌리는 것 아님
            cost[0][i] = arr[0][i];
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(cost[i][0] + ", " + cost[i][1] + ", " + cost[i][2]);
//        }
//        System.out.println("========================================");
        // 두번째 집부터 계산
        for (int i = 1; i < n; i++) {
//            System.out.println("RGB : " + arr[i][0] + ", " + arr[i][1] + ", " + arr[i][2]);
            cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + arr[i][0]; //이번 R : 이전 (G,B)비용 중 최솟값
            cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + arr[i][1]; //이번 G : 이전 (R,B)비용 중 최솟값
            cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + arr[i][2]; //이번 B : 이전 (R,G)비용 중 최솟값


//            System.out.println("======= i - 1 =============");
//            System.out.println(cost[i - 1][0] + ", " + cost[i - 1][1] + ", " + cost[i - 1][2]);
//            System.out.println("======= i  =============");
//            System.out.println(cost[i][0] + ", " + cost[i][1] + ", " + cost[i][2]);
        }

        //출력
//        for (int i = 0; i < n; i++) {
//            System.out.println(cost[i][0] + ", " + cost[i][1] + ", " + cost[i][2]);
//        }
        int min = Math.min(cost[n - 1][0], cost[n - 1][1]);
        return Math.min(min, cost[n - 1][2]);
    }
}
