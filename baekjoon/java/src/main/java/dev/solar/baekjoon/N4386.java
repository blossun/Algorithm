package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N4386 {
    static int[] xy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Node> graph = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        double[][] coordinates = new double[n][2]; //별자리 좌표
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i] = new double[]{Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())};
        }

        //별자리 사이의 거리 - 간선정보 저장
        // (1, 2, 3) -> (1, 2) (1, 3) (2, 3) 경우의 수를 모두 봐야한다.
        xy = new int[2];
        bt(graph, coordinates, 0, 0);

        //최소 신장 트리
        double result = kruskal(n, graph);
        System.out.println(result);
    }

    private static double kruskal(int n, PriorityQueue<Node> graph) {
        // 1. 간선의 크기가 가장 작은 것을 뽑는다.
        // 2. 선택한 간선의 두 정점이 같은 그룹인지 비교
        // 2-1. 같은 그룹이면 skip
        // 2-2. 다른 그룹이면 같은 그룹으로 만들고, 선택한 간선을 최소 신장 트리에 추가
        // 3. 1~2를 반복하고, 최소 신장 트리에 V-1개 간선이 선택되면 종료

        // 부모 정보 저장 - 같은 부모인지 확인용
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        double result = 0;
        int cnt = 0;
        while (!graph.isEmpty()) {
            Node node = graph.poll();
            if (isEqualParent(parent, node.a, node.b)) {
                continue;
            }
            result += node.cost;
            cnt++;
            union(parent, node.a, node.b);
            if (cnt == n - 1) break;
        }
        return result;
    }

    private static void union(int[] parent, int prev, int cur) {
        int prevParent = getParent(parent, prev);
        int curParent = getParent(parent, cur);
        if (prevParent < curParent) {
            parent[curParent] = prevParent;
            return;
        }
        parent[prevParent] = curParent;
    }

    private static boolean isEqualParent(int[] parrent, int a, int b) {
        return getParent(parrent, a) == getParent(parrent, b);
    }

    private static int getParent(int[] parent, final int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void bt(final PriorityQueue<Node> graph, final double[][] coordinates, final int start, final int k) { //현재 k번째 선택
        if (k == 2) {
            // 거리 비용 계산
            double[] a = coordinates[xy[0]];
            double[] b = coordinates[xy[1]];
            graph.add(new Node(xy[0], xy[1], Math.sqrt(Math.pow(b[1] - a[1], 2) + Math.pow(b[0] - a[0], 2))));
            return;
        }

        for (int i = start; i < coordinates.length; i++) {
            xy[k] = i;
            bt(graph, coordinates, i + 1, k + 1);
        }

    }

    private static class Node implements Comparable<Node> {
        int a;
        int b;
        double cost;

        public Node(final int a, final int b, final double cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(final Node o) {
            return (int) this.cost - (int) o.cost;
        }
    }
}
