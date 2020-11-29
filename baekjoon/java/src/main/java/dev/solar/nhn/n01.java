package dev.solar.nhn;

import java.util.Stack;

public class n01 {
    public static void main(String[] args) {
//        int[] goods = {46, 62, 9};
//        int[] goods = {50,62,93};
        int[] goods = {5, 31, 15};
        int total = solution(goods);
        System.out.println(total);
    }

    private static int solution(int[] goods) {
        int total = 0;
        // 50이상인 가격 stack
        Stack<Integer> over50 = new Stack<>();
        // 50미만 가격 stack
        Stack<Integer> under50 = new Stack<>();
        for (int good : goods) {
            if (good >= 50)
                over50.add(good);
            else {
                under50.add(good);
            }
        }

        //50미만의 가격상품이 있다면
        int tmp = 0;
        while (!under50.isEmpty()) {
            tmp += under50.pop();
        }
        if (tmp >= 50) {
            over50.add(tmp);
            tmp = 0;
        }

        //50이상의 가격들에 대해서 할인을 적용
        while (!over50.isEmpty()) {
            total += over50.pop() - 10;
        }

        //50미만의 가격들은 모두 더함
        total += tmp;
        return total;
    }
}
