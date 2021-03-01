package dev.solar.codility;

public class GenomicRangeQuery {
    /*
    * A,C,G,T : 1, 2, 3, 4
    * */
    public int[] solution(String S, int[] P, int[] Q) {
        char[] stringChars = S.toCharArray();
        int numberOfQuery = P.length;
        int[] result = new int [numberOfQuery];

        for (int i = 0; i < numberOfQuery; i++) {
            int startChar = P[i];
            int endChar = Q[i];

            int minValue = 5;
            for (int x = startChar; x <= endChar; x++) {
                DNA dna = DNA.valueOf(String.valueOf(stringChars[x]));
                minValue = Math.min(minValue, dna.numericalValue);
            }
            result[i] = minValue;
        }

        return result;
    }

    public enum DNA {
        A('A', 1),
        C('C', 2),
        G('G', 3),
        T('T', 4)
        ;

        private char code;
        private final int numericalValue;

        DNA(char code, int numericalValue) {
            this.code = code;
            this.numericalValue = numericalValue;
        }

    }
}
