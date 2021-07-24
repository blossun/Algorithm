package dev.solar.programmers;

public class N12911 {
    public int solution(int n) {
        int moveCount = 0; //전체 자리 이동 횟수
        int countOfOne = 0; //1이 등장한 횟수
        //1이 나올 때까지 우로 쉬프트
        while (true) {
            if ((n & 1) == 1) { //마지막 한자리를 확인해서 1이 나오면 stop
                break;
            }
            n = n >> 1;
            moveCount++;
        }
        //0이 나올 때까지 우로 쉬프트
        while (true) {
            if ((n & 1) == 0) { //0이 나오면 stop
                break;
            }
            n = n >> 1;
            countOfOne++;
            moveCount++;
        }
        //0의 자리에 1을 대입, 1의 갯수 -1
        //전체 자리 이동 횟수 만큼 좌로 쉬프트 -> 0으로 자릿수를 채워준다.
        //단 countOfOne만큼 뒤에 1로 채워줘야 하기 때문에 1이 들어가야하는 위치 전까지만 0으로 채운다.
        for (n++, countOfOne--; moveCount != countOfOne ; moveCount--) {
            n = n << 1;
        }
        // countOfOne만큼 1로 뒷부분을 채워준다.
        while (countOfOne > 0) {
            n = n << 1;
            n++;
            countOfOne--;
        }
        return n;
    }

    public int solution03(int n) {
        int countOfOne = Integer.bitCount(n);
        while (true) {
            if (countOfOne == Integer.bitCount(++n)) {
                break;
            }
        }
        return n;
    }

    public int solution02(int n) {
        // 15 -> binary : 1111
        String binaryString = Integer.toBinaryString(n);
        char[] chars = new char[binaryString.length() + 1];
        int lastIndexOfOne = binaryString.lastIndexOf('1');
        int countOfOne = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                countOfOne++;
            }
        }
        while (lastIndexOfOne > 0) {
            if (binaryString.charAt(lastIndexOfOne) == '1') {
                lastIndexOfOne--;
                continue;
            }
            // 1이 등장한 이후 0이 나왔다면
            chars[lastIndexOfOne + 1] = '1';
            break;
        }
        // '1'로 바뀐 index 기준으로 왼쪽은 binaryString과 동일하게 오른쪽은 0으로 초기화
        if (lastIndexOfOne == 0) {
            chars[0] = '1';
            lastIndexOfOne--;
        } else {
            chars[0] = '0';
        }

        for (int i = 0; i < lastIndexOfOne; i++) {
            chars[i + 1] = binaryString.charAt(i);
            if (binaryString.charAt(i) == '1') {
                countOfOne--;
            }
        }
        for (int i = lastIndexOfOne + 1; i < chars.length - 1; i++) {
            chars[i + 1] = '0';
        }

        int idx = chars.length - 1;
        while (countOfOne > 1) {
            if (chars[idx] == '0') {
                chars[idx] = '1';
                countOfOne--;
            }
            idx--;
        }

        return Integer.parseInt(String.valueOf(chars), 2);
    }
}
