package dev.solar.temp;

public class Woo04 {
    public int solution(int[] pobi, int[] crong) {
        int pobiResult = calculate(pobi);
        if (pobiResult == -1) {
            return -1;
        }
        int crongResult = calculate(crong);
        if (crongResult == -1) {
            return -1;
        }

        System.out.println("pobi : " + pobiResult + "crong : " + crongResult);
        if (pobiResult > crongResult) {
            return 1;
        } else if (pobiResult < crongResult) {
            return 2;
        }
        return 0;
    }

    private int calculate(final int[] pages) {
        if (!isValid(pages)) {
            return -1;
        }
        return Math.max(maxSumOfDigit(pages), maxMultiplyOfDigit(pages));
        // 각 자리수를 모두 합
        // 각 자리수를 모두 곱
    }

    private int maxMultiplyOfDigit(final int[] pages) {
        int max = 0;
        for (int page : pages) {
            String numberString = String.valueOf(page);
                int sum = 1;
            for (int i = 0; i < numberString.length(); i++) {
                sum *= numberString.charAt(i) - '0';
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private int maxSumOfDigit(final int[] pages) {
        int max = 0;
        for (int page : pages) {
            String numberString = String.valueOf(page);
            int sum = 0;
            for (int i = 0; i < numberString.length(); i++) {
                sum += numberString.charAt(i) - '0';
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private boolean isValid(final int[] pages) {
        return pages[1] - 1 == pages[0];
    }
}
