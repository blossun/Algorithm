package dev.solar.programmers;

public class N43163 {
    int answer; //변환 최소 단계
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        answer = 51; //최대 words로 들어올 수 있는 길이 : 50 에 +1한 값을 저장
        visited = new boolean[words.length];

        dfs(begin, target, 0, words);
        // 변환할 수 없는 경우 판단해서 반환
        // 51이라는 것은 아무런 해가 없었다는 것을 의미 => 즉, 변환 불가능한 경우 0을 리턴
        return answer == 51 ? 0 : answer;
    }

    private void dfs(String currentWord, String target, int count, String[] words) {
        if (currentWord.equals(target)) {
            // 최소한 변환된 횟수를 저장해야 한다. (이전에 구해진 결과와 현재 결과 중 최솟값 저장)
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isChangeable(currentWord, words[i])) { //사용되지 않았고, 조건에 맞으면
                visited[i] = true;
                dfs(words[i], target, count + 1, words); // words[i]가 현재 문자로 지정되고, target을 확인하러 깊이 탐색
                visited[i] = false;
            }
        }
    }

    private boolean isChangeable(String prevWord, String nextWord) {
        // 한글자가 차이나는지 확인
        int diff = 0;
        int length = prevWord.length();
        for (int i = 0; i < length; i++) {
            if (prevWord.charAt(i) != nextWord.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
