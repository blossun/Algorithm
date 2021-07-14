package dev.solar.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};

        for (int i = 1; i < arr.length; i++) {//1. 두번째 위치부터 탐색 시작
            int temp = arr[i];
            int prev = i - 1;
            //2. 이전 위치(index)를 가리키는 prev가 음수가 되지 않고,
            // 이전 위치(index)의 값이 1번의 값보다 크면 서로 교환하고,
            // prev를 더 이전 위치를 가리키도록 한다.
            while ((prev >= 0) && arr[prev] > temp) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            //3.prev에는 현재 temp 값보다 작은 값들 중 제일 큰 값의 위치(index) 를 가리키게 된다.
            // 따라서, (prev+1)에 temp 값을 삽입
            arr[prev+1] = temp;
        }
    }
}
