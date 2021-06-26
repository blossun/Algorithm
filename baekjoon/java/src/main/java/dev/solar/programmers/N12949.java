package dev.solar.programmers;

public class N12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowSize = arr1.length;
        int mSize = arr1[0].length;
        int colSize = arr2[0].length;
        int[][] answer = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                int sum = 0;
                for (int m = 0; m < mSize; m++) {
                    sum += arr1[row][m] * arr2[m][col];
                }
                answer[row][col] = sum;
            }
        }
        return answer;
    }
}
