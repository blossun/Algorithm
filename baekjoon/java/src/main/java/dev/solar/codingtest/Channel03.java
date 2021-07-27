package dev.solar.codingtest;

public class Channel03 {
    String result = "0";
    int N;
    boolean[] visited;

    public String solution(String letters, int k) {
        N = k;
        visited = new boolean[letters.length()];
        // 이게 백트래킹으로 될까..?
        // 일단 하나 구한 문자열이랑 첫 자리랑 계속 비교해나가면서 순서가 앞서면 바로 skip ??
        dfs("", 0, letters);

        return result;
    }

    private void dfs(String str, int startIdx, String letters) {
        if (str.length() == N) {
            System.out.println("str => " + str);
            //N개를 선택해 문자열이 만들어졌으면 문자열 순서를 확인해서 사전 순으로 더 뒤에 온다면 교환
            if (str.compareTo(result) > 0) {
                result = str;
            }
            return;
        }

        for (int i = startIdx; i < letters.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String nextStr = str + letters.charAt(i);
                //최적화 : 이미 완성된 result의 앞 글자보다 사전 순으로 더 앞에 온다면 확인할 필요가 없다.
                if (nextStr.compareTo(result) < 0) {
                    visited[i] = false;
                    continue;
                }
                dfs(str + letters.charAt(i), i + 1, letters);
                visited[i] = false;
            }
        }
    }
}
