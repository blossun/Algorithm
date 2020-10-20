package dev.solar.baekjoon;

import java.util.Scanner;

public class N1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int max = sc.nextInt();
        int[] female = new int[7];
        int[] male = new int[7];
        int gender;
        int grade;
        int totalRoom = 0;
        for (int i = 0; i < total; i++) {
            gender = sc.nextInt();
            grade = sc.nextInt();
            if (gender == 0) { //성별에 따라 방에 배정
                female[grade]++;
                if (female[grade] == max) { // 방이 다 찬 경우 초기화(새로운 방)
                    totalRoom++;
                    female[grade] = 0;
                }
            } else {
                male[grade]++;
                if (male[grade] == max) {
                    totalRoom++;
                    male[grade] = 0;
                }
            }
        }
        // 최종 방 갯수 확인 : 빈방(값이 0인 곳)제외하고 count
        for (int i : male) {
            if (i != 0) {
                totalRoom++;
            }
        }
        for (int i : female) {
            if (i != 0) {
                totalRoom++;
            }
        }
        System.out.println(totalRoom);
    }
}

/*
남학생 방 배열1
여학생 방 배열2
각 인덱스 : 학년
해당 방에 들어가 최대인원이 된다면 방 수를 +1 하고 해당 방을 0으로 초기화
 */
