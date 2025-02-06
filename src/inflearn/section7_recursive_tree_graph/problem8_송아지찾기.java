package inflearn.section7_recursive_tree_graph;

import java.util.*;

public class problem8_송아지찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(solution(s, e));
    }

    /**
     * distance 범위 (distance < 1 || distance > 10000) 통해서 Runtime error 및 time limit 막기!
     *
     */
    private static int solution(int s, int e) {
        Deque<Node> dq = new ArrayDeque<>();
        boolean[] isVisited = new boolean[10001];
        dq.offer(new Node(0, s));

        while (!dq.isEmpty()) {
            Node polledNode = dq.poll();
            int depth = polledNode.depth;
            int distance = polledNode.distance;

            if (distance < 1 || distance > 10000 || isVisited[distance]) continue;
            if (distance == e) return depth;
            isVisited[distance] = true;

            dq.offer(new Node(depth + 1, distance + 1));
            dq.offer(new Node(depth + 1, distance - 1));
            dq.offer(new Node(depth + 1, distance + 5));
        }
        return -1;
    }

    static class Node {
        int depth;
        int distance;

        public Node(int depth, int distance) {
            this.depth = depth;
            this.distance = distance;
        }
    }
}
