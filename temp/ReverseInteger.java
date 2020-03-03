package com.Solar.Algorithm.ReverseInteger;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 3;
        int sign = x > 0 ? 0 : 1;
        x = sign == 1 ? x*(-1) : x;
        String numString = Integer.toString(x);
        char[] numChars = numString.toCharArray();

        char[] reverseChars = new char[numChars.length];

        for (int i=0; i<numChars.length; i++) {
            int reverseIndex = numChars.length - (i+1) ;
            reverseChars[i] = numChars[reverseIndex];
        }

        String reverseStr;
        reverseStr = String.copyValueOf(reverseChars);

        try {
            int reverseNum = Integer.parseInt(reverseStr);
            result = sign == 1 ? reverseNum*(-1): reverseNum;
        } catch ( NumberFormatException e ) { //Range Check
            result = 0;
        }

        return result;
    }
}
