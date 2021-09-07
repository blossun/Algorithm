package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        // 상근이와 몇촌 관계인지 저장 - 상근이 : 0, 상근이 친구 : 1, 친구의 친구 :2
        int[] depth = new int[n + 1];
        int INF = 100_000_0001;
        Arrays.fill(depth, INF);

        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        while (m-- > 0) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        depth[1] = 0; //자기 자신은 0촌

        int count = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            count++;
            List<Integer> friends = graph[cur];
            for (Integer friend : friends) {
                if (depth[friend] != INF) {
                    continue;
                }
//                System.out.println("friend => " + friend);
                depth[friend] = Math.min(depth[friend], depth[cur] + 1);
                if (depth[friend] >= 3) {
                    break;
                }
                queue.add(friend);
            }
        }
//        Arrays.stream(depth).forEach(System.out::println);
        System.out.println(count - 1);
    }
}
