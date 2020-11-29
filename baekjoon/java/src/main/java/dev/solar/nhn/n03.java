package dev.solar.nhn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class n03 {
    static List<Integer> numberCount = new ArrayList<>(); //넘겨받은 알파벳 갯수 파악
    static int twoCase = 1; //0(delete Max) 또는 1(delete Min)로 어떤 것을 삭제할 지 결정
    static int depth; //depth 개의 수열 (길이)
    static List<Integer> results = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        String s = "aaaaabbc";
        int n = 1;
        int result = solution(s, n);
        System.out.println(result);
    }

    public static int solution(String s, int n) throws IOException {
        char[] str = s.toCharArray();
        int[] alpha = new int[26];
        // 각 알파벳이 몇번 등장했는지 카운팅
        for (int ch : str) {
            alpha[ch - 'a']++;
        }
        // 존재하는 알파벳만 따로 모음
        for (int i : alpha) {
            if (i == 0)
                continue;
            numberCount.add(i);
        }

        for (int i = 1; i <= n; i++) { // 1 ~ n 까지의 순열을 구해서 계산
            depth = i; //길이가 depth인 수열
            arr = new int[depth];
            sequence(0);

        }

        return Collections.min(results);
    }

    private static void sequence(int k) {
        if (k == depth) {
            deleteCharacter(arr);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            arr[k] = i;
            sequence(k + 1);
        }
    }

    private static void deleteCharacter(int[] arr) {
//        for (int i : arr) {
//            System.out.print(i + " - ");
//        }
//        System.out.println();

        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(numberCount); //깊은 복사
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int max = Collections.max(tmp);
//                System.out.println("max index : " + tmp.indexOf(max));
                tmp.set(tmp.indexOf(max), max - 1);
            } else {
                int min = Collections.min(tmp);
//                System.out.println("min index : " + tmp.indexOf(min));
                tmp.set(tmp.indexOf(min), min - 1);
            }
        }
        tmp.remove(Integer.valueOf(0));
        results.add(Collections.max(tmp) - Collections.min(tmp));
    }
}
