package dev.solar.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class N67257 {
    Set<String> operationPriorities = new HashSet<>(); //연산자 우선순위 순열 경우의 수 저장
    boolean[] visited;
    List<String> operandList = new LinkedList<>(); //연산자 저장
    List<Long> numberList = new LinkedList<>(); //피연산자 저장

    public long solution(String expression) {
        // 1. 연산자 & 피연산자 파싱해서 저장
        parsingExpression(expression);

        // 2.연산자 우선순위 경우의 수를 구해서 저장한다. (순열)
        makeOperation(expression);

        // 3.우선순위 경우의 수마다 계산을 해서 최댓값을 반환
        long result = 0;
        for (String operationPriority : operationPriorities) {
            result = Math.max(result, Math.abs(calculate(operationPriority))); //음수면 절댓값과, 기존값 중 큰 수 저장
        }
        return result;
    }

    private long calculate(String operationPriority) {
        // 원복 데이터를 copy
        List<String> operands = new LinkedList<>();
        operands.addAll(operandList);

        List<Long> numbers = new LinkedList<>();
        numbers.addAll(numberList);

        for (int i = 0; i < operationPriority.length(); i++) {
            Character curOper = operationPriority.charAt(i); //현재 우선순위 연산자

            for (int j = 0; j < operands.size(); j++) {
                if (!operands.get(j).equals(curOper.toString())) {
                    continue;
                }
                long result = calculate(numbers.get(j), numbers.get(j + 1), curOper);
                numbers.remove(j + 1);
                numbers.remove(j);
                operands.remove(j);
                numbers.add(j, result);
                j--;
            }
        }

        return numbers.get(0);
    }

    private long calculate(Long n1, Long n2, char curOper) {
        long result = 0;
        switch (curOper) {
            case '+':
                result = n1 + n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '-':
                result = n1 - n2;
                break;
        }
        return result;
    }

    private void parsingExpression(String expression) {
        numberList = new LinkedList<>(Arrays.asList(Arrays.stream(expression.replaceAll("[\\D]", " ") //숫자만 남도록
                .split(" "))
                .mapToLong(Long::parseLong)
                .boxed()
                .toArray(Long[]::new)));

        operandList = Arrays.stream(expression.replaceAll("[\\d]", "") //숫자가 아닌 문자만 남도록
                .split(""))
                .collect(Collectors.toList());
    }

    private long calculate(String expression, String operationPriority) {
//        List<Integer> currentOperand = Copy
        return 0;
    }

    private void makeOperation(String expression) {
        // 숫자를 지우고 수식만 남긴다. 중복된 수식은 삭제
        String operator = Arrays.stream(expression.replaceAll("[\\d]", "")
                .split(""))
                .distinct()
                .collect(Collectors.joining());
        // 수식 순열 구하기
        visited = new boolean[operator.length()];
        dfs("", operator);
    }

    private void dfs(String current, String operator) {
        if (current.length() == operator.length()) {
            operationPriorities.add(current);
            return;
        }

        for (int i = 0; i < operator.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + operator.charAt(i), operator);
                visited[i] = false;
            }
        }
    }
}
