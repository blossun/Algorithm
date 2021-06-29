package dev.solar.programmers;

public class N12911 {
    public int solution(int n) {
        // 15 -> binary : 1111
        String binaryString = Integer.toBinaryString(n);
        char[] chars = new char[binaryString.length() + 1];
        int lastIndexOfOne = binaryString.lastIndexOf('1');
        int countOfOne = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                countOfOne++;
            }
        }
        while (lastIndexOfOne > 0) {
            if (binaryString.charAt(lastIndexOfOne) == '1') {
                lastIndexOfOne--;
                continue;
            }
            // 1이 등장한 이후 0이 나왔다면
            chars[lastIndexOfOne + 1] = '1';
            break;
        }
        // '1'로 바뀐 index 기준으로 왼쪽은 binaryString과 동일하게 오른쪽은 0으로 초기화
        if (lastIndexOfOne == 0) {
            chars[0] = '1';
            lastIndexOfOne--;
        } else {
            chars[0] = '0';
        }

        for (int i = 0; i < lastIndexOfOne; i++) {
            chars[i + 1] = binaryString.charAt(i);
            if (binaryString.charAt(i) == '1') {
                countOfOne--;
            }
        }
        for (int i = lastIndexOfOne + 1; i < chars.length - 1; i++) {
            chars[i + 1] = '0';
        }

        int idx = chars.length - 1;
        while (countOfOne > 1) {
            if (chars[idx] == '0') {
                chars[idx] = '1';
                countOfOne--;
            }
            idx--;
        }

        return Integer.parseInt(String.valueOf(chars), 2);
    }
}
