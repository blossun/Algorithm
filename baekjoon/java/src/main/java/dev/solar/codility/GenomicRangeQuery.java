package dev.solar.codility;

public class GenomicRangeQuery {
    private int[] arrA;
    private int[] arrC;
    private int[] arrG;

    /*
     * A,C,G,T : 1, 2, 3, 4
     * */
    public int[] solution(String S, int[] P, int[] Q) {
        char[] stringChars = S.toCharArray();
        arrA = new int[S.length() + 1];
        arrC = new int[S.length() + 1];
        arrG = new int[S.length() + 1];
        int[] result = new int[P.length];

        // 초기에 문자열의 등장 변화를 기록
        for (int i = 0; i < stringChars.length; i++) {
            switch (stringChars[i]) {
                case 'A':
                    arrA[i + 1]++;
                    break;
                case 'C':
                    arrC[i + 1]++;
                    break;
                case 'G':
                    arrG[i + 1]++;
                    break;
            }
            arrA[i + 1] += arrA[i];
            arrC[i + 1] += arrC[i];
            arrG[i + 1] += arrG[i];
        }

        for (int i = 0; i < result.length; i++) {
            int startIndex = P[i];
            int endIndex = Q[i];

            if (startIndex == endIndex) {
                switch (stringChars[startIndex]) {
                    case 'A':
                        result[i] = 1;
                        break;
                    case 'C':
                        result[i] = 2;
                        break;
                    case 'G':
                        result[i] = 3;
                        break;
                    default:
                        result[i] = 4;
                }
            } else if (arrA[startIndex] != arrA[endIndex + 1]) { //arrA[startIndex] == arrA[endIndex] 라면 등장하지 않았다는 의미
                result[i] = 1;
            } else if (arrC[startIndex] != arrC[endIndex + 1]) {
                result[i] = 2;
            } else if (arrG[startIndex] != arrG[endIndex + 1]) {
                result[i] = 3;
            } else {//'T'가 제일 작은 값인 경우
                result[i] = 4;
            }
        }
        return result;
    }
}
