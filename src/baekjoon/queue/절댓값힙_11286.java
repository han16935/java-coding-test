package baekjoon.queue;

import java.util.*;
import java.io.*;

public class 절댓값힙_11286 {

    static int n;
    static PriorityQueue<Node> pq = new PriorityQueue();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) bw.write("0\n");
                else bw.write(pq.poll().value + "\n");
            }

            else pq.offer(new Node(num));
        }
        bw.flush();
    }

    static class Node implements Comparable<Node>{
        int value;
        int abs;

        public Node(int value) {
            this.value = value;
            this.abs = Math.abs(value);
        }

        @Override
        public int compareTo(Node other) {
            if (this.abs == other.abs) return this.value - other.value;
            else return this.abs - other.abs;
        }
    }
}
