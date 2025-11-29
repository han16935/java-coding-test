package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class 공주님정원_2457_IMPORTANT {
    static int n, answer;
    static List<Flower> list = new ArrayList<>();
    static int current = 301;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            list.add(new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay));
        }

        Collections.sort(list);

        int index = 0;
        int maxEnd = 0;

        while (current < 1201) {
            boolean found = false;

            while (index < n && list.get(index).start <= current) {
                maxEnd = Math.max(maxEnd, list.get(index).end);
                index++;
                found = true;
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            answer++;
            current = maxEnd;
        }

        System.out.println(answer);
    }

    static class Flower implements Comparable <Flower> {
        int start;
        int end;

        public Flower (int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo (Flower other) {
            if (this.start == other.start) return other.end - this.end;
            else return this.start - other.start;
        }

    }
}
