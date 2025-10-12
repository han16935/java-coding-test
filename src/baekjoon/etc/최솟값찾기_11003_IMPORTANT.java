package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 최솟값찾기_11003_IMPORTANT {
    static int n, l;
    static int [] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Node> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // push, pop, peek / offer, poll
        for (int j=1;j<=n;j++) {

            while (!deque.isEmpty() && deque.getFirst().value > arr[j]) {
                deque.removeFirst();
            }

            if (!deque.isEmpty() && j - l + 1 > 0 && j - l + 1 > deque.getLast().index) {
                deque.removeLast();
            }

            deque.push(new Node(j, arr[j]));
            bw.write(deque.getLast().value + " ");
        }

        bw.flush();
    }

    static class Node {
        int index;
        int value;

        public Node (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
