package dev.solar.programmers;

public class N43105 {
    public int solution(int[][] triangle) {
        int row = triangle.length;
        for (int r = row - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                triangle[r][c] += Math.max(triangle[r + 1][c], triangle[r + 1][c + 1]);
            }
        }
        return triangle[0][0];
    }
}
