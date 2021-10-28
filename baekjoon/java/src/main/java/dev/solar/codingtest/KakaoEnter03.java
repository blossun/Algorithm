package dev.solar.codingtest;

public class KakaoEnter03 {
    public static long minOperations(long n) {
        char[] chars = Long.toBinaryString(n).toCharArray();
        boolean isAppliedRule02 = false;
        long count = 0;
        int index = 0;
        while (index < chars.length) {
            if (chars[index] == '0') {
                index++;
                continue;
            }
            if (!isAppliedRule02) {
                changeChar(chars, chars.length - 1);
                isAppliedRule02 = true;
                if (index == chars.length - 1) {
                    index++;
                }
            } else {
                int changingIndex = canChangeIndex(chars);
                if (changingIndex == -1) {
                    isAppliedRule02 = false;
                    continue;
                }
                changeChar(chars, changingIndex);
                isAppliedRule02 = false;
                if (index == changingIndex) {
                    index++;
                }
            }
            count++;
        }

        return count;
    }

    private static int canChangeIndex(final char[] chars) {
        int validIndex = -1;
        for (int index = chars.length - 2; index >= 0; index--) {
            boolean valid = true;
            if (chars[index + 1] != '1') {
                continue;
            }
            for (int i = index + 2; i < chars.length; i++) {
                if (chars[i] != '0') {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                validIndex = index;
                break;
            }
        }
        return validIndex;
    }

    private static void changeChar(char[] chars, int index) {
        if (chars[index] == '1') {
            chars[index] = '0';
            return;
        }
        chars[index] = '1';
    }
}
