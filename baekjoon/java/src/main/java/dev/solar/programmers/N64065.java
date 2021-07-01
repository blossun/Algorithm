package dev.solar.programmers;

import java.util.*;

public class N64065 {
    public int[] solution(String s) {
        String[] set = s.substring(1, s.length() - 1).replace("},{", "}/{").split("/");
        // 길이가 작은 것을 먼저오도록 오름차순 정렬 -> 어떤 요소가 먼저 나오는지 봐야하기 때문에
        Arrays.sort(set, (o1, o2) -> o1.length() - o2.length());
        List<String> element = new LinkedList<>();
        for (String str : set) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(str.substring(1, str.length() - 1).split(",")));
            for (String e : element) {
                while (true) {
                    String poll = queue.poll();
                    if (poll.equals(e)) {
                        break;
                    }
                    queue.add(poll);
                }
            }
            element.add(queue.poll());
        }
        return element.stream().mapToInt(Integer::parseInt).toArray();
    }

    public int[] solution2(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}
