package baekjoon.greedy;

import java.util.*;
import java.io.*;

/**
 * S의 최솟값이 되게 하기 위해서는 A 배열의 최솟값과 B 배열의 최댓값을 곱한 값을 더하면 됨
 */
public class 보물_1026 {

    static int n, answer;
    static PriorityQueue<Integer> minPq = new PriorityQueue<>(); // A 수열
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // B 수열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            minPq.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            maxPq.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            answer += minPq.poll() * maxPq.poll();
        }

        System.out.println(answer);
    }
}
