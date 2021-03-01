package dev.solar.codility;

public class PermMissingElem {
    public int solution(int[] arr) {
        boolean[] isAppeared = new boolean[arr.length + 2]; //1부터 시작하고, 한 개 빠진 갯수이므로 +2한 사이즈로 잡아줘야한다.
        isAppeared[0] = true; //0은 나올일이 없으므로 기본적으로 true로 만듬
        // arr과 동일한 크기의 boolean 배열을 만들어서 해당 값이 등장했는지 여부를 기록
        // O(2N)
        // isAppeared 배열을 순회하다가 false(없는값)인 값을 return;
        for (int a : arr) {
            isAppeared[a] = true;
        }
        for (int i = 1; i < isAppeared.length; i++) {
            if (!isAppeared[i]) {
                return i;
            }
        }
        return -1;
    }
}

/*
Your test case: []
Returned value: 1
 */
