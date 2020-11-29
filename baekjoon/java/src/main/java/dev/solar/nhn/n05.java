package dev.solar.nhn;

public class n05 {
    public static void main(String[] args) {
//        int[] votes = {5, 7, 7};
        int[] votes = {10,10,10,10};
        System.out.println(solution(votes));
    }

    private static int solution(int[] votes) {
        int count = 0;
        while (true) {
            int v0 = votes[0];
            if (votes.length == 0) //후보0이 유일
                break;
            int max = v0;
            int maxIndex = 0;
            for (int i = 1; i < votes.length; i++) { //최대 득표 후보 구하기
                if (votes[i] >= max) {
                    max = votes[i];
                    maxIndex = i;
                }
            }
            // 후보 0 이 최대 득표자면 종료
            if (maxIndex == 0)
                break;

            //최대 득표자의 표를 0번 후보자에게
            votes[0]++;
            count++;
            votes[maxIndex]--;
        }

        return count;
    }
}
