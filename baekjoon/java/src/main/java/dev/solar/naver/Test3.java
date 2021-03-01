package dev.solar.naver;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test3 {
    static int N = 4;
    static int M = 4;
    static boolean[] used = new boolean[4]; // 해당 자리값 사용 여부
    static int[] arr = new int[4]; // 4자리 수열 생성용
    static Set<String> result = new LinkedHashSet<>(); // 중복 제거
    static int[] digits = new int[4]; // 주어진 수
    static StringBuilder sb = new StringBuilder();

    public int solution(int A, int B, int C, int D) {
        digits[0] = A;
        digits[1] = B;
        digits[2] = C;
        digits[3] = D;

        Arrays.sort(digits);
        backTracking(0);
        for (String s : result) {
            System.out.println(s);
        }
        int count = result.size();

        return count;
    }

    private void backTracking(int k) { //k번째 수 뽑기
        if (k == M) { //하나의 경우가 완성
            for (int i : arr) {
                sb.append(i);
            }
            result.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {

                // 첫째 자리 수 조건
                if (k == 0 && digits[i] >= 3) {
                        continue;
                }

                // 둘째 자리 수 조건
                if (k == 1 && arr[0] == 2) { //첫째자리가 2로 시작하는 경우
                    if (digits[i] >= 4) {
                        continue;
                    }
                }

                // 셋째 자리 수 조건
                if (k == 2 && digits[i] >= 7) {
                        continue;
                }

                // 넷째 자리 수 조건
                if (k == 3 && arr[2] == 6) {
                    if (digits[i] >= 1) {
                        continue;
                    }
                }

                arr[k] = digits[i];
                used[i] = true;
                backTracking(k + 1);
                used[i] = false;
            }
        }
    }
}
