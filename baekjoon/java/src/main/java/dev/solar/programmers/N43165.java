package dev.solar.programmers;

public class N43165 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);
        return answer;
    }

    public int dfs(int[] numbers, int target, int sum, int index) { //index : 현재까지 선택한 인덱스 갯수
        if (index == numbers.length) { // index를 size만큼 다 둘러봤다면 return
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        result += dfs(numbers, target, sum + numbers[index], index + 1);
        result += dfs(numbers, target, sum - numbers[index], index + 1);
        return result;
    }
}
