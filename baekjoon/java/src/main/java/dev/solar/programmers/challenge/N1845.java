package dev.solar.programmers.challenge;

import java.util.HashSet;

public class N1845 {
    public int solution(int[] nums) {
        HashSet<Integer> pocketmon = new HashSet<>();
        for (int num : nums) {
            pocketmon.add(num);
        }

        return pocketmon.size() >= nums.length / 2 ? nums.length / 2 : pocketmon.size();
    }
}
