package dev.solar.programmers.weekly;

public class N05 {
    static int count;
    static char[] chars = {'A', 'E', 'I', 'O', 'U'};
    static boolean stop = false;

    public int solution(String word) {
        dfs(0, "", word);
        return count;
    }

    private void dfs(final int depth, final String str, final String word) {
        if (depth == 6) {
            count--;
            return;
        }

        if (str.equals(word)) {
            stop = true;
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (stop) {
                return;
            }

//            if (depth + 1 < 6) { //depth가 6일 때 +1하면 안 됨
//                count++;
//            }
            count++;
            dfs(depth + 1, str + chars[i], word);
        }

    }
}
