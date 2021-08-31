package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N11725 {
    public static void main(String[] args) throws IOException {
        /**
         * input
         * 1 6
         * 6 3
         * 3 5
         * 4 1
         * 2 4
         * 4 7
         *
         * 트리
         *          1
         *         /  \
         *       6      4
         *      /     /   \
         *    3     2       7
         *   /
         * 5
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] tree = new LinkedList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new LinkedList<>();
        }

        // 트리 채우기
        // 양방향으로 채운다.
        for (int i = 0; i < N - 1; i++) {
            String[] nodes = br.readLine().split(" ");
            int from = Integer.parseInt(nodes[0]);
            int to = Integer.parseInt(nodes[1]);
            tree[from].add(to);
            tree[to].add(from);
        }

        int[] parent = new int[N + 1];
        // bfs - 부모 배열 채우기
        // 그래프를 양방향으로 채웠으므로 이미 부모 배열이 채워져 있다면 앞서 지나간 것이므로 skip
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); //root는 1부터
        parent[1] = 1; //root 노드이기 때문에 부모를 자기 자신으로
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int i = 0; i < tree[cur].size(); i++) {
                Integer next = tree[cur].get(i);
                if (next == parent[cur]) continue; //부모 노드일 경우 건너뜀
                //부모가 아니면 큐에 넣고 p[nxt] = cur로 만들어 준다.
                queue.offer(next);
                parent[next] = cur;
            }
        }

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }

    }
}
