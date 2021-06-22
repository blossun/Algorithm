package dev.solar.programmers;

public class N17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 10진수 -> 2진수로 변환
        // n x n 모양의 정사각 배열이 나오는데, 결국 arr1의 length만큼 열의 길이가 되어야 하므로 n = length
        // 둘 중 하나라도 1이면 벽('#')으로 출력
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars1 = String.format("%"+ n + "s", Integer.toBinaryString(arr1[i])).replaceAll(" ", "0").toCharArray();
            char[] chars2 = String.format("%"+ n + "s", Integer.toBinaryString(arr2[i])).replaceAll(" ", "0").toCharArray();
            for (int j = 0; j < n; j++) {
                if (chars1[j] == '1' || chars2[j] == '1') {
                    result[i][j] = '#';
                } else {
                    result[i][j] = ' ';
                }
            }
        }

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.valueOf(result[i]);
        }
        return answer;
    }
}
