package dev.solar.programmers;

import java.util.Arrays;
import java.util.stream.Stream;

public class N49191 {
    public int solution(int n, int[][] results) {
        boolean[][] D = new boolean[n+1][n+1]; //승부 결과 테이블

        // 자기자신을 제외한 나머지 사람들과의 승부 결과가 저장되어있다면 순위 파악 가능
        // (a,b) -> a가 b를 이겼음을 표시. b가 a에게 졌음을 표시
        // 주어진 경기 결과를 채운다.
        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            D[win][lose] = true;
        }
        // 경기 결과로 알 수 있는 다른 사람의 승패결과를 채운다.

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
//                    if (start != end && D[mid][start] * D[mid][end] == -1) {
//                        // (3, 2) (1,2)의 경우 (1,3)의 결과는 알 수 없다. (3, 2) (2, 1) -> (3, 1)
//                        D[start][end] = D[start][mid]; // (3, 2) (1, 2)
//                        D[end][start] = D[mid][end];
//                    }
                    if(D[start][mid] && D[mid][end]) {
                        D[start][end] = true;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int result = 0;
            for (int j = 1; j <= n; j++) {
                if (D[i][j] || D[j][i]) {
                    result++;
                }
            }
            if (result == n-1) answer++;
        }
        return answer;
    }
}
