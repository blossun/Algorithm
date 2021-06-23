package dev.solar.kakao;

import java.util.HashMap;

public class N67256 {
    public String solution(int[] numbers, String hand) {
        HashMap<Integer, Point> keyPad = new HashMap<>();
        initKeyPad(keyPad);
        int left = -1;
        int right = 10;
        int distanceOfLeft = 0;
        int distanceOfRight = 0;
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append('L');
                left = number;
                continue;
            }
            if (number == 3 || number == 6 || number == 9) {
                sb.append('R');
                right = number;
                continue;
            }
            Point leftPoint = keyPad.get(left);
            Point rightPoint = keyPad.get(right);
            Point numberPoint = keyPad.get(number);
            distanceOfLeft = Math.abs(numberPoint.x - leftPoint.x) + Math.abs(numberPoint.y - leftPoint.y);
            distanceOfRight = Math.abs(numberPoint.x - rightPoint.x) + Math.abs(numberPoint.y - rightPoint.y);
            if (distanceOfLeft < distanceOfRight) {
                sb.append('L');
                left = number;
            } else if (distanceOfLeft > distanceOfRight) {
                sb.append('R');
                right = number;
            } else {
                if (hand.equals("right")) {
                    sb.append('R');
                    right = number;
                } else {
                    sb.append('L');
                    left = number;
                }
            }
        }

        return sb.toString();
    }

    private void initKeyPad(HashMap<Integer, Point> keyPad) {
        keyPad.put(1, new Point(0, 0));
        keyPad.put(2, new Point(1, 0));
        keyPad.put(3, new Point(2, 0));
        keyPad.put(4, new Point(0, 1));
        keyPad.put(5, new Point(1, 1));
        keyPad.put(6, new Point(2, 1));
        keyPad.put(7, new Point(0, 2));
        keyPad.put(8, new Point(1, 2));
        keyPad.put(9, new Point(2, 2));
        keyPad.put(0, new Point(1, 3));
        keyPad.put(-1, new Point(0, 3)); // '*'
        keyPad.put(10, new Point(2, 3)); // '#'
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
