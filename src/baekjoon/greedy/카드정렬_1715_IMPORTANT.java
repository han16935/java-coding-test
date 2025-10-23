package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class 카드정렬_1715_IMPORTANT {
    static int n;
    static long answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        for (int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }

        while (pq.size() > 1) {
            int combinedDeckSize = pq.poll() + pq.poll();
            answer += combinedDeckSize;
            pq.offer(combinedDeckSize);
        }

        System.out.println(answer);
    }
}
