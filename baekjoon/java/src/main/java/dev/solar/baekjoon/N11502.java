package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11502 {
    private static Node top;
    private static int count;
    private static int sumOfChild;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            top = new Node(Integer.parseInt(st.nextToken())); //맨 처음 노드
            while (--N > 0) { // 맨 처음 입력받은 횟수 차감 후 시작
                Node cur = new Node(Integer.parseInt(st.nextToken()));
                if (cur.value >= top.value) {
                    cur.setLeft(top);
                    top = cur;
                } else {
                    if (top.getRight() == null) {
                        top.setRight(cur);
                    } else {
                        Node parentNode = top;
                        while (parentNode.getRight() != null) {
                            if (cur.value >= parentNode.getRight().value) {
                                cur.setLeft(parentNode.getRight());
                                break;
                            } else {
                                parentNode = parentNode.getRight();
                            }
                        }
                        parentNode.setRight(cur);
                    }
                }
            }

            int total = 0;
            while (top != null && top.getLeft() != null) {
                count = 0;
                sumOfChild = 0;
                preorder(top.getLeft());
                total += top.value * count - sumOfChild;
                top = top.getRight();
            }
            System.out.println(total);
        }
    }

    private static void preorder(Node top) {
        if (top == null) {
            return;
        }

        count++;
        sumOfChild += top.value;
        preorder(top.getLeft());
        preorder(top.getRight());
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }
}
