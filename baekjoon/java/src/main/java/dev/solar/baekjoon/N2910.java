package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        List<Node> arr = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            Node newNode = new Node(num);
            int index = arr.indexOf(newNode);
            if (index != -1) {
                arr.get(index).plus();
            } else {
                arr.add(newNode);
            }
        }


        Collections.sort(arr);
        Iterator<Node> it = arr.iterator();
        while (it.hasNext()) {
            Node node = it.next();
            for (int i = 0; i <= node.count; i++) {
                sb.append(node.number).append(' ');
            }
        }

        System.out.println(sb);
    }

    private static class Node implements Comparable<Node> {
        private int number;
        private int count;

        public Node(int number) {
            this.number = number;
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public void plus() {
            count++;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count != o.count) {
                return o.count - this.count;
            }
            return 0; //빈도수가 같다면 기존 정렬 순서 유지
        }

        @Override
        public boolean equals(Object o) { //number가 같으면 같은 객체
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return number == node.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }
}
