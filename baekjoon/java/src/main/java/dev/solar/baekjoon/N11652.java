package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> nodes = new LinkedList<>();

        while (N-- > 0) {
            long number = Long.parseLong(br.readLine());
            Node newNode = new Node(number);
            int index = nodes.indexOf(newNode);
            if (index != -1) {
                nodes.get(index).plus();
            } else {
                nodes.add(newNode);
            }
        }

        Collections.sort(nodes);
        System.out.println(nodes.get(0).number);
    }

    private static class Node implements Comparable<Node>{
        public Long number;
        public int count;

        public Node(long number) {
            this.number = number;
            this.count = 0;
        }

        public void plus() {
            count++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return Objects.equals(number, node.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public int compareTo(Node o) {
            if (this.count != o.count) {
                return o.count - this.count;
            } else {
                return this.number.compareTo(o.number);
            }
        }
    }
}
