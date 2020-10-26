package dev.solar.baekjoon;

import java.io.*;
import java.util.Stack;

public class N1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int i = 1;

        while (i <= max) {
            if (i == number) {
                left.push(i);
                sb.append("+\n");
                right.push(left.pop());
                sb.append("-\n");
                if (i < max) {
                    number = Integer.parseInt(br.readLine());
                }
                i++;
            } else {
                // 입력값보다 i 가 작은/큰 경우
                if (i < number) { //작으면 오름차순으로 계속해서 next 입력값이 나올 때까지 left에 push
                    left.push(i);
                    sb.append("+\n");
                    i++;
                } else { //큰 경우 left에 push해 놓은 값들을 pop해서 같은지 확인
                    if (left.peek().equals(number)) { //같으면 pop해서 right로 이동
                        right.push(left.pop());
                        sb.append("-\n");
                        number = Integer.parseInt(br.readLine());
                    } else { //다르면 만들 수 없는 수열이므로 바로 "NO"를 출력하고 종료
                        System.out.print("NO");
                        return ;
                    }
                }
            }
        }

        // 최곳값 이후 left 스택과 남은 입력값을 비교
        // left 스택에 남은 값이 남은 입력값 보다 적게 남은 경우....?
        if (!left.empty()) {
            number = Integer.parseInt(br.readLine());
        }

        while (!left.empty()) {
            if (left.pop() == number) {
                sb.append("-\n");
                if (left.empty()) {
                    break;
                }
                number = Integer.parseInt(br.readLine());
            } else {
                System.out.print("NO");
                return ;
            }
        }

        System.out.println(sb);
        br.close();
    }
}

/*
그냥 1 ~ 부터 해서 순서대로 입력값과 비교
~~입력값과 순서가 같다면 left 스택에 push~~
~~다르다면 right 스택에 push~~ -> 무조건 1부터 오름차순으로 입력 받아야
최고값을 만났을 때, left 모든 값을 pup해서 right에 push

반례 : 1 /1  가능 -> ArrayIndexOutOfBoundsException: -1 에러 처리
반례 : 4 / 1234 가능 {푸팝푸팝푸팝푸팝}함
 */
