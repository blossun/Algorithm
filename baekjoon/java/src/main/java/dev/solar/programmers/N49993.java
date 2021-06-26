package dev.solar.programmers;

public class N49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            int currentIndex = 0;
            boolean possible = true;
            for (int i = 0; i < skill.length(); i++) {
                char ch = skill.charAt(i);
                int skillTreeIndex = skill_tree.indexOf(ch);
                if (skillTreeIndex == -1) {
                    currentIndex = skill_tree.length(); //skill_tree에 skill이 없는 경우
                    continue;
                }
                if (skillTreeIndex < currentIndex) { // 불가능한 스킬트리 체크
                    possible = false;
                    break;
                }
                currentIndex = skillTreeIndex;
            }
            if (possible) {
                answer++;
            }
        }
        return answer;
    }
}
// CBD -> BDA (X)
//      ACB (O)
//      AC (O)
//      A (O)
