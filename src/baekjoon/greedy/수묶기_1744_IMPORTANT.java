package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class 수묶기_1744_IMPORTANT {

    static int n;
    static long answer;
    static PriorityQueue<Integer> positivePq = new PriorityQueue<>(Collections.reverseOrder()); // 양수
    static PriorityQueue<Integer> negativePq = new PriorityQueue<>(); // 음수 및 0

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) answer++;
            if (num > 1) positivePq.offer(num);
            if (num <= 0) negativePq.offer(num);
        }

        while (positivePq.size() > 1) {
            answer += positivePq.poll() * positivePq.poll();
        }

        if (positivePq.size() == 1) answer += positivePq.poll();

        while (negativePq.size() > 1) {
            answer += negativePq.poll() * negativePq.poll();
        }

        if (negativePq.size() == 1) answer += negativePq.poll();

        System.out.println(answer);
    }
}
