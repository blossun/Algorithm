package dev.solar.codingtest;

import java.util.HashSet;

public class ChannelTalk04 {
    char[] chars;
    boolean[] used;
    int count = 0;
    int length;
    String result;
    HashSet<String> words = new HashSet<>();
    public String solution(int n, int m, int k) {
        length = n + m;
        chars = new char[length];
        used = new boolean[length];
        for (int i = 0; i < n; i++) {
            chars[i] = '(';
        }
        for (int i = n; i < length; i++) {
            chars[i] = ')';
        }
        dfs("", 0, k);
        return result;
    }

    private void dfs(String str, int idx, int k) {
        if (idx == length) { //하나가 완성된 경우
            if (words.contains(str)) {
                return ;
            }
            words.add(str);
            count++;
            if (count == k) {
                result = str;
            }
            return ;
        }
        

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(str + chars[i], idx + 1, k);
                if (count == k) {
                    return;
                }
                used[i] = false;
            }
        }
    }
}
