package dev.solar.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};

        int temp = 0;
        for (int i = 0; i < arr.length; i++) { //1. 제외될 원소의 갯수
            for (int j = 1; j < arr.length - i; j++) { //2. 원소를 비교할 index를 뽑을 반복문
                if (arr[j-1] > arr[j]) { //j : 현재 원소, j-1:이전 원소
                    //swap(arr[j-1], arr[j])
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
    }
}
