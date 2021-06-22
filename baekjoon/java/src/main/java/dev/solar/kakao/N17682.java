package dev.solar.kakao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N17682 {
    public int solution(String dartResult) {
        // 1. 문자열 3셋트를 한 셋트당 점수로 분리
        // 정규표현식을 사용해서 하나의 셋트 단위로 분리
        // ex) 1D#2S*3S => 1D#, 2S*, 3S 로 분리
        String[] setGrade = new String[3]; //총 3세트
        String regex = "[0-9]*[S,D,T]{1}[*|#]?";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(dartResult);
        for (int i = 0; i < 3; i++) {
            m.find();
            setGrade[i] = String.valueOf(m.group());
        }
        int[] grades = new int[3];
        for (int i = 0; i < 3; i++) {
            char[] chars = setGrade[i].toCharArray();
            int grade = 0;
            for (char ch : chars) {
                if (ch >= '0' && ch <= '9') {
                    grade = grade * 10 + (ch - '0');
                    continue;
                }
                if (ch == 'D') {
                    grade *= grade;
                    continue;
                } else if (ch == 'T') {
                    grade = grade * grade * grade;
                    continue;
                } else if (ch == 'S') {
                    continue;
                }
                if (ch == '*') {
                    if (i != 0) { //맨 처음 점수만 아니라면 이전 점수를 x2 해준다.
                        grades[i - 1] *= 2;
                    }
                    grade *= 2; //현재 점수도 x2 해준다.
                }
                if (ch == '#') {
                    grade *= -1;
                }
            }
            grades[i] = grade;
        }

        int answer = grades[0] + grades[1] + grades[2];
        return answer;
    }
}
