package dev.solar.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println("answer : " + Arrays.toString(solution.solution(orders, course)));
    }
}

class Solution2 {
    static List<String> thisCombinations = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {

        List<String> allCombinations = new ArrayList<>();
        List<String> answerList = new ArrayList<>();

//        ArrayList<String> courses = new ArrayList();
        for (String order : orders) { //하나의 주문마다

            //나올 수 있는 코스 조합
            System.out.println("order : " + order);
            List<String> makedCombinations = courseCombination(course, order);
            // allCombination에 있으면 answer에 추가
            // 없으면 allCombination에 추가
            for (String makedCombination : makedCombinations) {
                System.out.println("thisCombination : " + makedCombination);
                if (allCombinations.contains(makedCombination)) {
                    System.out.println("있다!!");
                    // answerList에 없는 경우에만 추가
                    if (!answerList.contains(makedCombination)) { //이미 들어가지 않은 경우
                        // allCombinations에있는 코스에 '포함' 되는 경우가 아닐때만 추가
                        //ACDE,
                        //ACD
                        //ACE
                        //AC => ACDE에 포함되어있음
//                        for (String answer : answerList) {
//                            if (!answer.contains(makedCombination)) {
//                                //ac, acde 여도 ac 자체만으로 주문에 들어온 경우면 추가해야함
//                                answerList.add(makedCombination);
//                            }
//                        }
                        answerList.add(makedCombination);
                    }
                } else {
                    System.out.println("없다!!");
                    allCombinations.add(makedCombination);
                }
            }
        }

        //정렬
        Collections.sort(answerList);
        String[] answer = answerList.toArray(new String[answerList.size()]);

        for (String s : answer) {
            System.out.println(s);
        }
        return answer;
    }

    List<String> courseCombination(int[] course, String order) {
        System.out.println("[*] call couseCombination =======================>");
        List<String> makedCombinations = new ArrayList<>();
        // thisCombinations 초기화
        thisCombinations.clear();
        List<String> arr = Arrays.asList(order.split(""));
        int dishCount = arr.size();
        Collections.sort(arr); //정렬
        for (int r : course) {
            reculsion(arr, makedCombinations, 0, dishCount, r);
        }
        makedCombinations.addAll(thisCombinations);

        for (int i = 0; i < makedCombinations.size(); i++) {
            String s = makedCombinations.get(i);
            System.out.println(s);
            s = s.substring(1, s.length()-1);
            s = s.replace(" ", "");
            s = s.replace(",", "");
            makedCombinations.set(i, s);
        }
        return makedCombinations;
    }

    void reculsion(List<String> stringList, List<String> result, int index, int n, int r) { //기준 리스트, 결과, 반복문 시작 indes, 전체갯수, 뽑을 갯수
        if (r == 0) {
            System.out.println(result.toString());
            thisCombinations.add(result.toString());
            return;
        }

        for (int i = index; i < n; i++) {
            result.add(stringList.get(i));
            reculsion(stringList, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }
}
