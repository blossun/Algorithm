package dev.solar.programmers;

public class N12950 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int y = arr1[0].length;
        int[][] answer = new int[x][y];
        for (int i = 0; i < x; i++) {
            int[] arr1Low = arr1[i];
            int[] arr2Low = arr2[i];
            for (int j = 0; j < y; j++) {
                answer[i][j] = arr1Low[j]+arr2Low[j];
            }
        }
        return answer;
    }
}
