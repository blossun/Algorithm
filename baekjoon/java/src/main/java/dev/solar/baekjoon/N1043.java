package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int peopleCount = Integer.parseInt(st.nextToken());
        int partyCount = Integer.parseInt(st.nextToken());

        // 1. Union-find 초기화
        int[] parent = new int[peopleCount + 1];
        for (int i = 1; i < peopleCount + 1; i++) {
            parent[i] = i;
        }

        // 2. 진실을 아는 사람
        boolean[] truth = new boolean[peopleCount + 1];
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            truth[Integer.parseInt(st.nextToken())] = true;
        }

        // 3. 같은 파티에 참석한 사람들 union
        LinkedList<Integer>[] parties = new LinkedList[partyCount];
        for (int i = 0; i < partyCount; i++) {
            parties[i] = new LinkedList<>();
        }
        int prev = 0;
        int cur = 0;
        for (int i = 0; i < partyCount; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            prev = Integer.parseInt(st.nextToken());
            parties[i].add(prev);
            for (int j = 1; j < n; j++) {
                cur = Integer.parseInt(st.nextToken());
                parties[i].add(cur);
                union(parent, prev, cur); // 두 명씩 union하면 모두 같은 parent를 갖게 된다.
                prev = cur;
            }
        }

        // 4. 진실을 아는 사람들의 parent는 같이 파티를 참여 했으므로 진실을 아는 사람들로 갱신
        for (int i = 1; i < truth.length; i++) {
            if (truth[i]) {
                truth[getParent(parent, i)] = true;
            }
        }

        // 5. 진실을 아는 사람들과 같이 파티를 하지 않은 사람들 수만 카운트
        int total = 0;
        for (int i = 0; i < partyCount; i++) {
            if (parties[i].size() > 0) {
                int parentPerson = getParent(parent, parties[i].get(0));
                if (!truth[parentPerson]) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }

    private static void union(final int[] parent, final int prev, final int cur) {
        int prevParent = getParent(parent, prev);
        int curParent = getParent(parent, cur);
        if (prevParent < curParent) {
            parent[curParent] = prevParent;
        } else {
            parent[prevParent] = curParent;
        }
    }

    private static int getParent(final int[] parent, final int x) {
        if (parent[x] == x) {
            return x;
        }
        return getParent(parent, parent[x]);
    }
}
