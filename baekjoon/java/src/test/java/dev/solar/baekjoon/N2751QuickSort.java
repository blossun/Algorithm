package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2751QuickSort {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        QuickSort qs = new QuickSort();
        qs.quickSort(0, arr.length);
        for (int i : arr) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    static class QuickSort {
        private void quickSort(int st, int en) {
            if (st + 1 >= en) //수열의 길이가 1 이하이면 함수 종료.(base condition)
                return;
            int rPos = quick(st, en);
            quickSort(st, rPos);
            quickSort(rPos + 1, en);
        }

        private int quick(int st, int en) {
            int pivot = arr[st];
            int lidx = st + 1;
            int ridx = en - 1;
            while (true) {
                //l은 pivot보다 큰 값이 나올 때 까지 오른쪽으로 이동
                while (lidx < en) {
                    if (arr[lidx] > pivot)
                        break;
                    lidx++;
                }
                //r은 pivot보다 작거나 같은 값이 나올 때 까지 왼쪽으로 이동
                while (ridx > st) {
                    if (arr[ridx] < pivot)
                        break;
                    ridx--;
                }
                if (ridx < lidx) { // l과 r이 역전되는 그 즉시 탈출
                    break;
                }
                int tmp = arr[lidx];
                arr[lidx] = arr[ridx];
                arr[ridx] = tmp;
            }
            arr[st] = arr[ridx];
            arr[ridx] = pivot;
            return ridx;
        }
    }
}

