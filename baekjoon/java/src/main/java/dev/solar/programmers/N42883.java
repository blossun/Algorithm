package dev.solar.programmers;

public class N42883 {
    public String solution(String number, int k) {
        StringBuilder numbers = new StringBuilder(number); //String -> List<Integer> 로 굳이 만들지 않고, charAt으로 접근하도록 수정
        while (k > 0) {
            int left = 0;
            int right = 1;
            boolean removed = false;
            while (!removed) {
                if (left == numbers.length() - 1) { //마지막요소인 경우
                    k--;
                    numbers.deleteCharAt(left);
                    removed = true;
                    continue;
                }
                if (numbers.charAt(left) < numbers.charAt(right)) {
                    k--;
                    numbers.deleteCharAt(left);
                    removed = true;
                    continue;
                }
                left++;
                right++;
            }
        }

        return numbers.toString();
    }
}
