package dev.solar.programmers.challenge;

public class N77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 1. 최저 순위를 먼저 구한다. -> 0을 제외하고 맞는 숫자 갯수에 따라서 결정
        // 2. 최고 순위는 구해진 최저 순위 - 0의 갯수를 하면 된다. => 잘못된 로직. 1개를 맞춰서 6등인지 0개를 맞춰서 6등인지 모르므로
        int countOfZero = 0; //0 갯수
        int countOfMatch = 0; //맞춘 갯수
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                countOfZero++;
                continue;
            }
            if (isMatched(lottos[i], win_nums)) {
                countOfMatch++;
            }
        }

        // 등수 확인 : 7 - (맞은 갯수) = 등수
        int minRanking  = (7 - countOfMatch) > 6 ? 6 : 7 - countOfMatch; //1개가 맞은 경우나 0개가 맞은 경우나 6등임
        // 0 갯수만큼 맞은 수를 더해줌
        countOfMatch += countOfZero;
        int maxRanking  = (7 - countOfMatch) > 6 ? 6 : 7 - countOfMatch; //1개가 맞은 경우나 0개가 맞은 경우나 6등임
        return new int[]{maxRanking, minRanking};
    }

    // win_numbs가 6개 밖에 안되니깐 그냥 for 문으로 돌려서 확인함... 더 사이즈가 컷다면 HashMap으로 하면 빠를듯
    private boolean isMatched(int number, int[] win_nums) {
        for (int win_num : win_nums) {
            if (win_num == number) {
                return true;
            }
        }
        return false;
    }
}
