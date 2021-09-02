package dev.solar.algorithm;

public class UnionFind {
    public static void main(String[] args) {
        int[] parent = new int[11];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        union(parent, 1, 2);
        union(parent, 2, 2);
        union(parent, 3, 4);
        union(parent, 5, 6);
        union(parent, 6, 7);
        union(parent, 7, 8);
        System.out.println("1과 5는 연결되어 있나요 ?" + isEqualParent(parent, 1, 5));
        union(parent, 1, 5);
        System.out.println("1과 5는 연결되어 있나요 ?" + isEqualParent(parent, 1, 5));

    }

    // 각 부모 노드를 합친다.
    private static void union(final int[] parent, final int prev, final int cur) {
        int prevParent = getParent(parent, prev);
        int curParent = getParent(parent, cur);
        if (prevParent < curParent) {
            parent[curParent] = prevParent;
        } else {
            parent[prevParent] = curParent;
        }
    }

    // 부모노드 정보를 가져온다.
    private static int getParent(final int[] parent, final int x) {
        if (parent[x] == x) {
            return x;
        }
        return getParent(parent, parent[x]);
    }

    // 같은 부모 노드를 가지는지 확인
    private static int isEqualParent(final int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b ? 1 : 0;
    }
}
