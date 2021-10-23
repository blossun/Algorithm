package dev.solar.codingtest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringJoiner;

public class NHN01 {
    public static void solution(int numOfOperation, Operation[] operations) {
        // 사용중인 브랜치
        LinkedList<Integer> branches = new LinkedList<>();
        branches.add(1);
        // 사용할 수 있는 브랜치 시작번호
        int branchNumber = 2;
        // 재사용할 수 있는 브랜치 번호 - 낮은 순으로 꺼내와야 한다.
        PriorityQueue<Integer> usableNumber = new PriorityQueue<>();
        for (int i = 0; i < numOfOperation; i++) {
            Operation operation = operations[i];
            if (operation.type.equals(OperationType.branch)) {
                //재사용할 수 있는 브랜치가 있다면 사용
                if (!usableNumber.isEmpty()) {
                    Integer poll = usableNumber.poll();
                    branches.add(poll);
                    continue;
                }
                branches.add(branchNumber++);
                continue;
            }
            if (operation.type.equals(OperationType.merge)) {
                branches.remove(operation.value);
                usableNumber.add(operation.value);
                continue;
            }
        }

        Collections.sort(branches);
        StringJoiner sj = new StringJoiner(" ");
        for (Integer branch : branches) {
            sj.add(String.valueOf(branch));
        }
        System.out.println(sj.toString());
    }

    private static class Operation {
        OperationType type;
        Integer value;

        public Operation(final OperationType type, final Integer value) {
            this.type = type;
            this.value = value;
        }
    }

    private static enum OperationType {
        branch,
        merge;
    }
}
