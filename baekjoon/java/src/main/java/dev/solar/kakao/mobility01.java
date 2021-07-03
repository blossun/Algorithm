package dev.solar.kakao;

public class mobility01 {
    public String solution(String S) {
        // write your code in Java SE 8
        // 3글자씩 -로 구분
        // 한글자는 안되고 마지막글자가 하나가 되면 앞에 3-1 -> 2-2로 나눠야함
        // 1. S에서 숫자만 추출
        // 2. 마지막이 1개가 남는지 확인 -> length % 3 == 1인 경우
        // S에 숫자가 업는경우 ?
        String nubmerStr = S.replaceAll("[^0-9]", "");
//        int endIndex = (numbers.length % 3 == 1) ?
        StringBuilder sb = new StringBuilder();
        String remainStr = cutString(nubmerStr, sb);
        while (remainStr != null) {
            remainStr = cutString(remainStr, sb);
        }
        return sb.toString().substring(1);
    }

    private String cutString(String str, StringBuilder sb) {
        if (str.length() == 4) {
            sb.append("-").append(str, 0, 2);
            return str.substring(2);
        }
        // 12, 123, 12345, 123456
        if (str.length() <= 3) {
            sb.append("-").append(str);
            return null;
        }
//        int index = str.length() % 3;
        sb.append("-").append(str, 0, 3);
        return str.substring(3);
    }
}
