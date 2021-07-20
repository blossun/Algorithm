package dev.solar.programmers;

import java.util.*;

public class N72411 {
    static HashMap<String, Integer> courseMenu; //코스조합 별 주문 횟수 저장

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new LinkedList<>();

        // 각 주문(order)의 메뉴명을 오름차순으로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] chArr = orders[i].toCharArray();
            Arrays.sort(chArr);
            orders[i] = String.valueOf(chArr);
        }

        // course의 메뉴 갯수마다 메뉴의 조합을 구한다.
        for (int i = 0; i < course.length; i++) {
            courseMenu = new HashMap<>();
            int count = course[i];

            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder(); //구해질 조합의 문자를 붙여나간다.
                char[] menu = orders[j].toCharArray();
                if (count <= orders.length) { // 코스의 개수 <= 주문한 음식의 갯수 인 경우만 확인
                    combi(0, 0, count, menu, sb);
                }
            }

            //현재 코스의 메뉴 갯수에 해당하는 조합 중 가장 많이 주문된 횟수를 max에 저장
            int max = -1;
            for (Integer value : courseMenu.values()) {
                max = Math.max(max, value);
            }

            //주문이 2회 이상이고, max와 일치하는 조합은 결과로 저장
            if (max < 2) {
                continue;
            }
            for (Map.Entry<String, Integer> entry : courseMenu.entrySet()) {
                if (entry.getValue() == max) {
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    /**
     * 조합을 구한다.
     * @param idx
     * @param k : 현재 k 개수만큼 수를 선택
     * @param count : 뽑으려는 개수
     * @param menu
     * @param sb
     */
    private void combi(int idx, int k, int count, char[] menu, StringBuilder sb) {
        if (k == count) {
            // 조합을 뽑았으면, 해당 코스를 저장하고, 기존에 코스가 있다면 주문횟수 + 1 해서 저장. 없다면 1로 저장
            courseMenu.put(sb.toString(), courseMenu.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        // idx부터 시작해서 조합을 구한다.
        for (int i = idx; i < menu.length; i++) {
            sb.append(menu[i]);
            combi(i + 1, k + 1, count, menu, sb); //주의 idx가 아니라 i의 + 1 한 값이 시작점이다.
            sb.setLength(sb.length() - 1); //이전에 붙인 것 제거
        }
    }
}
