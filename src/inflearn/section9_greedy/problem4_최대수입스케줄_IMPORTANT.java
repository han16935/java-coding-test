package inflearn.section9_greedy;

import java.util.*;
import java.io.*;

public class problem4_최대수입스케줄_IMPORTANT {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Lecture> arr = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxPeriod = 0;
        int answer = 0;

        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int period = Integer.parseInt(st.nextToken());
            maxPeriod = Math.max(maxPeriod, period);
            arr.add(new Lecture(money, period));
        }

        Collections.sort(arr);

        int j = 0;

        // i일 째 강연 선택하기 위해
        for(int i=maxPeriod;i>0;i--) {

            // j를 밖에서 유지함으로써 iter 끝나도 계속 유지, period가 같은 애들을 삽입
            for( ;j<n && arr.get(j).period == i ; j++) {
                pq.offer(arr.get(j).money);
            }

            // pq 중 가장 큰 수 넣기
            if (!pq.isEmpty()) answer += pq.poll();
        }

        System.out.println(answer);
    }

    static class Lecture implements Comparable<Lecture> {

        int money;
        int period;

        public Lecture(int money, int period) {
            this.money = money;
            this.period = period;
        }

        @Override
        public int compareTo(Lecture other) {
            return other.period - this.period;
        }
    }
}
