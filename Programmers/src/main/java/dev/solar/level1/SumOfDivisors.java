package dev.solar.level1;

import java.util.HashSet;

public class SumOfDivisors {
    public int solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n%i == 0) {
                sum += i;
            }
        }
        return sum+n;
    }

    // 부족한 풀이
    public int solution2(int n) {
        if ( n==1 ) return n;
        int sum = 0;
        int middleN = n/2;
        HashSet<Integer> divisors = new HashSet();
        for (int i = 1; i <= middleN; i++) {
            if (n%i == 0) {
                divisors.add(i);
                divisors.add(n/i);
            }
        }
        for ( int num : divisors) {
            sum += num;
        }
        return sum;
    }
}
/*
* for문을 n/2까지 돌리는 건 생각했는데, 괜히 중복을 없애겠다고 HashMap 쓰고, 몫, 나누기를 생각함.
* 그냥 i를 더해주고 마지막에 sum에 n을 더해주면 된다.*/
