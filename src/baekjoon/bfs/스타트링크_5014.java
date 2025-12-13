package baekjoon.bfs;

import java.util.*;
import java.io.*;

public class 스타트링크_5014 {
    static int f, s, g, u, d;
    static boolean [] isVisited;
    static int answer = 0;

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        isVisited = new boolean[f + 1];

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(s, 0));
        isVisited[s] = true;
        while (!queue.isEmpty()) {
            Node polledNode = queue.poll();

            int currentFloor = polledNode.currentFloor;
            int count = polledNode.count;

            if (currentFloor == g) {
                answer = polledNode.count;
                break;
            }

            if (currentFloor + u <= f && !isVisited[currentFloor + u]) {
                queue.offer(new Node(currentFloor + u, count + 1));
                isVisited[currentFloor + u] = true;
            }

            if (1 <= currentFloor - d && !isVisited[currentFloor - d]) {
                queue.offer(new Node(currentFloor - d, count + 1));
                isVisited[currentFloor - d] = true;
            }
        }

        if (answer == 0) {
            if (s == g) System.out.println(0);
            else System.out.println("use the stairs");
        }

        else System.out.println(answer);
    }

    static class Node {
        int currentFloor;
        int count;

        public Node (int currentFloor, int count) {
            this.currentFloor = currentFloor;
            this.count = count;
        }
    }
}
