package dev.solar.codility;

public class CyclicRotation {
    public int[] solution(int[] arr, int K) {
        int sizeOfArr = arr.length;
        int[] result = new int[sizeOfArr];
        // 빈 배열의 경우 추가
        if (sizeOfArr == 0) {
            return result;
        }

        // 1. 길이가 n인 배열을 n번 회전시키면 원래 순서로 돌아온다.
        // 2. k번 회전은 (k % n)번 회전시키는 것과 같다.
        //   ex) 길이가 4인 배열에서 ) 5번 회전 == 1번 회전
        // 3. k번회전 한다는 것은 뒤에서 부터 k개의 데이터를 꺼내서 앞에서부터 채우고,
        //   arr(원래배열)의 0부터 (k-1)인덱스까지 꺼내서 넣는다.
        int countOfLocation = K % sizeOfArr;
        int startIdx = sizeOfArr - countOfLocation;
        for (int i = 0; i < countOfLocation; i++) {
            result[i] = arr[startIdx++];
        }
        startIdx = countOfLocation;
        for (int i = 0; i < sizeOfArr - countOfLocation; i++) {
            result[startIdx++] = arr[i];
        }

        return result;
    }
}
