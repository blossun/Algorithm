package dev.solar.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class N17680 {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        int runTime = 0;
        for (String city : cities) {
            if (cache.contains(city.toLowerCase())) { //대소문자 구분 안하므로 소문자저장
                cache.remove(city.toLowerCase());
                runTime++;
            } else {
                runTime += 5;
            }
            if (cache.size() >= cacheSize) { //LRU니깐 최근에 사용한 것일 수록 뒷부분에 위치시켜서 나중에 없어지도록 해야한다.
                cache.poll();
            }
            if (cache.size() < cacheSize) { //cacheSize가 0인 경우
                cache.offer(city.toLowerCase());
            }
        }
        return runTime;
    }
}
