package dev.solar.programmers;

import java.util.*;

public class N42627 {
    class Job {
        public int requestTime;
        public int workingTime;

        public Job(final int requestTime, final int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }

    public int solution(int[][] jobs) {
        //1.일단 먼저 들어온 작업은 먼저 처리
        //2. 처리 중에 동시에 들어온 작업이 있다면 짧은 것 먼저 처리
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(final Job o1, final Job o2) {
                return o1.workingTime - o2.workingTime;
            }
        });

        for (int[] job : jobs) {
            waiting.offer(new Job(job[0], job[1]));
        }

        // 먼저 들어온 순서대로 처리
        waiting.sort(Comparator.comparingInt(j -> j.requestTime));

        int answer = 0;
        int cnt = 0;
        int currentTime = waiting.peek().requestTime;

        while (cnt < jobs.length) {
            while (!waiting.isEmpty() && waiting.peek().requestTime <= currentTime) {
                pq.offer(waiting.pollFirst());
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll();
                currentTime += job.workingTime;
                answer += currentTime - job.requestTime;
                cnt++;
            } else {
                currentTime++;
            }
        }
        return answer / cnt;
    }

}
