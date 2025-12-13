package baekjoon.bfs;

import java.util.*;
import java.io.*;

public class 숨바꼭질3_13549 {

    public class Main {

        static int n, k;
        static int answer = Integer.MAX_VALUE;
        static boolean [] isVisited = new boolean[100001];
        static Deque<Node> queue = new ArrayDeque<>();

        public static void main (String [] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            queue.offer(new Node(n, 0));
            while (!queue.isEmpty()) {

                Node polledNode = queue.poll();
                int currentPos = polledNode.currentPos;
                int count = polledNode.count;

                if (currentPos == k) {
                    answer = Math.min(count, answer);
                    continue;
                }
                isVisited[currentPos] = true;

                if (currentPos + 1 <= 100000 && !isVisited[currentPos + 1]) queue.offer(new Node(currentPos + 1, count + 1));
                if (currentPos - 1 >= 0 && !isVisited[currentPos - 1]) queue.offer(new Node(currentPos - 1, count + 1));
                if (currentPos > 0 && currentPos * 2 <= 100000 && !isVisited[currentPos * 2]) queue.offer(new Node(currentPos * 2, count));
            }

            System.out.println(answer);
        }

        static class Node {
            int currentPos;
            int count;

            public Node(int currentPos, int count) {
                this.currentPos = currentPos;
                this.count = count;
            }
        }
    }
}
