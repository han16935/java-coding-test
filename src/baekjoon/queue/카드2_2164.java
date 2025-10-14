package baekjoon.queue;

import java.util.*;
import java.io.*;

public class 카드2_2164 {
    static int n;
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=1;i<=n;i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.peek());
    }
}
