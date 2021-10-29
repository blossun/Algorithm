package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class N13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfPerson = Integer.parseInt(st.nextToken());
        int waitingList = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < waitingList; i++) {
            String person = br.readLine();
            if (set.contains(person)) {
                set.remove(person);
            }
            set.add(person);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = set.iterator();
        while (numOfPerson-- > 0) {
            if (!iterator.hasNext()) {
                break;
            }
            sb.append(iterator.next()).append('\n');
        }
        System.out.println(sb.toString());
    }

}
