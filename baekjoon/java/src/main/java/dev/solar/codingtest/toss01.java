package dev.solar.codingtest;

public class Toss01 {
    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        // 공급대가 - 비과세 금액 == 1
        long pay = orderAmount - serviceFee;
        if (pay - taxFreeAmount == 1) {
            return 0;
        }
        long answer = Math.round((orderAmount - taxFreeAmount)*10) / 11;
        return answer;
    }
}
