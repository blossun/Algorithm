package dev.solar.kakao;

import java.util.HashSet;

public class mobility02 {
    public int solution(int[] T, int[] A) {
        HashSet<Integer> learnedSkill = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            learnedSkill.add(A[i]);
            int skill = T[A[i]];
            while (true) {
                if (learnedSkill.contains(skill)) {
                    break;
                }
                learnedSkill.add(skill);
                skill = T[skill];
            }
        }
        return learnedSkill.size();
    }
}
