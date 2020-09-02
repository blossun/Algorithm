package dev.solar.level1;

public class FindKim {
    public String solution(String[] seoul) {
//        int index = 0;
//        for (int i = 0; i < seoul.length; i++) {
//            if (seoul[i] == "Kim") {
//                index = i;
//            }
//        }
//        String answer = String.format("김서방은 %d에 있다", index);
//        return answer;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return String.format("김서방은 %d에 있다", i);
            }
        }
        return null;
    }
}
