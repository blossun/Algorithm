package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class N5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        String[] command;
        for (int i = 0; i < testCase; i++) {
            command = br.readLine().split("");
            int size = Integer.parseInt(br.readLine());
            String array = br.readLine();
            // 배열이 0인경우에 대한 처리
            String[] numbers;
            if (size > 0) {
                array = array.substring(1, array.length() - 1);
                numbers = array.split(",");
            } else {
                numbers = new String[0];
            }
            // Deque에 저장해야함
            Deque<Integer> deque = new LinkedList<>();
            for (String number : numbers) {
                deque.add(Integer.parseInt(number));
            }
            excuteCommand(command, deque);
        }
    }

    private static void excuteCommand(String[] command, Deque<Integer> deque) {
        boolean isRocated = false;
        for (String cmd : command) {
//            System.out.println("isRocated : " + isRocated);
            if ("R".equals(cmd)) {
                isRocated = !isRocated; //반전시킴
            } else if ("D".equals(cmd)) {
                if (!myD(deque, isRocated)) {
                    System.out.println("error");
                    return;
                }
            }
        }
        // isRocated == true 라면 거꾸로 뒤집한 상태니깐 뒤에서부터 출력해야함
        if (!isRocated) {
            System.out.println(deque.toString().replace(" ", "")); //출력에 공백있으면 안됨 ㅠㅠ
            return;
        } else {
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            while (!deque.isEmpty()) {
                sb.append(prefix);
                prefix = ",";
                sb.append(deque.removeLast());
            }
            System.out.println("[" + sb + "]");
        }
    }

    private static boolean myD(Deque<Integer> deque, boolean isRocated) { //복사되는 deque이면,,,, 시간이 오래 걸릴듯
        // queue가 비어있으면 false 리턴
        if (deque.isEmpty()) return false;
        //isRocated == false 라면
        if (!isRocated) {
            deque.removeFirst();
        } else {
            deque.removeLast();
        }
        //isRocated == true 라면
        return true;
    }
}
/*
D(버리기) 를 커스텀해서 R(뒤집기) 상태 값을 함께 넘겨받아서
0(정상) 이면 front 값을 삭제
1(뒤집힌 상태) 이면 back 값을 삭제
 */
