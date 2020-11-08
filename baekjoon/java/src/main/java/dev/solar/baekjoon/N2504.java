package dev.solar.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class N2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cmd = sc.nextLine().split("");
        Stack<String> st = new Stack<>();
        boolean isValid = true;

        for (int i = 0; i < cmd.length; i++) {
            // 여는 괄호일 경우 본인의 닫는 괄호를 스택에 저장한다.
            if (cmd[i].equals("(") ) {
                st.push(")");
                continue;
            }

            if (cmd[i].equals("[") ) {
                st.push("]");
                continue;
            }

            // 닫는 괄호인 경우
            int num = 0;
            while (true) {
                if (st.isEmpty()) { // 아직본인 괄호가 나오지 않았는데 스택이 비었다는 뜻 유효하지 않은 괄호 문자열
                    isValid = false;
                    break;
                }
                if (isNumeric(st.peek())) { // 스택에 담겨있는 숫자들은 다 더함
                    num += Integer.parseInt(st.pop());
                } else {
                    if (isVPS(cmd[i], st.peek())) {// 자신과 괄호 짝이 맞는지 확인
                        st.pop();
                        int tmp = (")".equals(cmd[i])) ? 2 : 3;

                        if (num == 0) {
                            st.push(String.valueOf(tmp));
                        } else {
                            st.push(String.valueOf(tmp * num));
                        }
                        break;
                    } else { // 괄호 쌍이 안맞으면 false
                        isValid = false;
                        break;
                    }
                }
            }
            if (!isValid) break; // 유효하지 않음이 판명되었으면 더이상 확인 하지 않음
        }

        int result = 0;
        while (!st.empty()) {
            if (isNumeric(st.peek())) {
                result += Integer.parseInt(st.pop());
            } else { // ( 나 ) 가 남아있으면 유효하지 않음
                isValid = false;
                break;
            }
        }

        if (isValid) System.out.println(result);
        else System.out.println(0);
    }

    static boolean isVPS(String cmd, String target) {
        return cmd.equals(target);
    }

    static boolean isNumeric(String str) {
        if (str.equals(")") || str.equals("]"))
            return false;
        return true;
    }
}
