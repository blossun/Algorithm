package dev.solar.baekjoon;

import java.io.*;
import java.util.*;

public class N1759 {
    private static int N, M;
    private static char[] chars; //암호로 사용될 문자들
    private static boolean[] used; //문자 사용 여부
//    private static Set<String> result = new LinkedHashSet<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        chars = new char[M];
        used = new boolean[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        bt(0, 0, 0, 0);
        System.out.println(sb);
        br.close();
    }

    // 조합 : arr 배열을 이용해서 n개 중에 r개 뽑기
    private static void bt(int start, int pick, int cntOfMo, int cntOfJa) {
        if (pick == N) {
            if (cntOfMo >= 1 && cntOfJa >= 2) {
                for (int i = 0; i < M; i++) {
                    if (used[i])
                        sb.append(chars[i]);
                }
                sb.append('\n');
            }
            return ;
        }

        for (int i = start; i < M; i++) {
            used[i] = true;
            bt(i + 1, pick + 1, cntOfMo + (isMo(chars[i]) ? 1 : 0), cntOfJa + (!isMo(chars[i]) ? 1 : 0));
            used[i] = false;
        }
    }

    private static boolean isMo(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
