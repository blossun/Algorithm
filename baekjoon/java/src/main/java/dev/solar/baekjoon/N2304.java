package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] xy = br.readLine().split(" ");
            points.add(new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
        }
        Collections.sort(points);
        //정렬이 잘 되었는지 확인
//        for (Point point : points) {
//            System.out.println(point.x + ", " + point.y);
//        }

        int totalArea = 0; //최종 다각형 면적
        Point leftMaxPoint = points.get(0); //왼쪽 방향에서부터 최고 꼭지점
        Point nextPoint;
        Point rightMaxPoint = points.get(N - 1); //오른쪽 방향에서부터 최고 꼭지점
        //마지막 지점의 좌표를 오른쪽으로 한칸 이동시켜서 넓이를 가질 수 있도록 한다.
        rightMaxPoint.x++;
        // 왼쪽에서 부터 최고 지점까지 영역
        int index = 0;
        while (index < N - 1) {
            nextPoint = points.get(index + 1);
            if (leftMaxPoint.y >= nextPoint.y) {
                index++;
                continue;
            }
            totalArea += ( nextPoint.x - leftMaxPoint.x ) * leftMaxPoint.y;
            System.out.println("left : "  + leftMaxPoint.x + ", " + leftMaxPoint.y + ", right : " + nextPoint.x + ", " + nextPoint.y)  ;
            System.out.println("totalArea : " + totalArea);
            leftMaxPoint = nextPoint;
            index++;
        }

        //오른쪽에서부터 최고 지점까지 영역
        index = N - 1;
        while (index > 0) {
            nextPoint = points.get(index - 1);
            if (rightMaxPoint.y >= nextPoint.y) {
                index--;
                continue;
            }
            totalArea += (rightMaxPoint.x - 1 - nextPoint.x) * rightMaxPoint.y; //너비가 있기때문에 우측 x 좌표로 계산하도록 -1 해줌
            System.out.println("right : " + rightMaxPoint.x + ", " + rightMaxPoint.y + ", left : "  + nextPoint.x + ", " + nextPoint.y);
            System.out.println("totalArea : " + totalArea);
            rightMaxPoint = nextPoint;
            index--;
        }

        //중간 영역이 있다면 영역 추가
        totalArea += (rightMaxPoint.x - leftMaxPoint.x ) * rightMaxPoint.y;
//        System.out.println("중간 영역 추가 -> totalArea : " + totalArea);

        //왼쪽 최고기둥과 오른쪽 최고 기둥이 다른경우
        //오른쪽 구역에서 가장 높은 기둥의 넓이를 추가
        if ((rightMaxPoint.x != leftMaxPoint.x) && leftMaxPoint.x != points.get(0).x && rightMaxPoint.x + 1 != points.get(N - 1).x)
            totalArea += rightMaxPoint.y;

        System.out.println(totalArea);

    }

    static class Point implements Comparable<Point> {
        Integer x;
        Integer y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point point) {
            return this.x.compareTo(point.x); //compareTo()를 쓰려면 reference 타입이어야 한다.
        }
    }

}
