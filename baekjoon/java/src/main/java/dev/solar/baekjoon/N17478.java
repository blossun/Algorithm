package dev.solar.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N17478 {
    static String preStr = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    static String questionStr = "\"재귀함수가 뭔가요?\"\n";
    static String answerStr1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String answerStr2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String answerStr3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    static String endingAnswerStr = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    static String endingStr = "라고 답변하였지.\n";
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        bw.write(preStr);
        recursiveQNA(N);
        bw.flush();
        bw.close();
    }

    static void recursiveQNA(int n) throws IOException {
        StringBuilder underStr = new StringBuilder();
        for (int i = 1; i <= 4 * (N - n); i++) {
            underStr.append('_');
        }

        if (n == 0) {
            bw.write(underStr + questionStr);
            bw.write(underStr + endingAnswerStr);
            bw.write(underStr + endingStr);
            return ;
        }

        bw.write(underStr + questionStr);
        bw.write(underStr + answerStr1);
        bw.write(underStr + answerStr2);
        bw.write(underStr + answerStr3);

        recursiveQNA(n - 1);
        bw.write(underStr + endingStr);
    }
}
