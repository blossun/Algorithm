package dev.solar.codingtest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Toss02 {
    public int[][] solution(int servers, boolean sticky, int[] requests) {
        if (sticky) {
            return stickySolution(servers, requests);
        }
        return rrSolution(servers, requests);
    }

    private int[][] rrSolution(final int numberOfServer, final int[] requests) {
        int[][] servers = new int[numberOfServer][requests.length / numberOfServer];
        int[] index = new int[numberOfServer];
        int server = 0;

        for (int i = 0; i < requests.length; i++) {
            servers[server][index[server]++] = requests[i];
            server = (server + 1) % numberOfServer;
        }

        return servers;
    }

    private int[][] stickySolution(final int numberOfServer, final int[] requests) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numberOfServer; i++) {
            map.put(i, new LinkedList<>());
        }

        // 어느 서버로 들어갔는지 저장
        HashMap<Integer, Integer> mapServer = new HashMap<>();
        int serverOrder = 0;

        for (int i = 0; i < requests.length; i++) {
            int request = requests[i];
            if (mapServer.containsKey(request)) {
                List<Integer> waitingQ = map.get(mapServer.get(request));
                waitingQ.add(request);
                continue;
            }
            List<Integer> waitingQ = map.get(serverOrder);
            waitingQ.add(request);
            mapServer.put(request, serverOrder);
            serverOrder = (serverOrder + 1) % numberOfServer;
        }

        int[][] answer = new int[numberOfServer][];
        for (int i = 0; i < numberOfServer; i++) {
            int[] ints = map.get(i).stream().mapToInt(j -> j).toArray();
            answer[i] = ints;
        }
        return answer;
    }
}
