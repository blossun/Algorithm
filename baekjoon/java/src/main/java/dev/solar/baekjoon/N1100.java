package dev.solar.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ClassTime[] classTimes = new ClassTime[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            classTimes[i] = new ClassTime(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        Arrays.sort(classTimes, Comparator.comparingInt(o -> o.start));
        List<Stack> classRooms = new LinkedList<>();
        Stack<Integer> s = new Stack();
        s.push(0);
        classRooms.add(s);
        for (ClassTime classTime : classTimes) {
            boolean isSet = false;
            Iterator<Stack> it = classRooms.iterator();
            while (it.hasNext()) {
                Stack st = it.next();
                if (Integer.parseInt(String.valueOf(st.peek())) <= classTime.start) {
                    st.add(classTime.end);
                    isSet = true;
                    break;
                }
            }
            if (!isSet) {
                Stack<Integer> st = new Stack();
                st.push(classTime.end);
                classRooms.add(st);
            }
        }
        System.out.println(classRooms.size());

    }

    private static class ClassTime implements Comparable<ClassTime>{
        public Integer start;
        public Integer end;

        public ClassTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ClassTime o) {
            return o.start - this.start;
        }
    }
}
