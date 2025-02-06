package inflearn.section7_recursive_tree_graph;

import java.util.*;

public class problem8_송아지찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(solution(s, e));
    }

    private static int solution(int s, int e) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(0, s));

        while(dq.peek().distance != e) {
            Node polledNode = dq.poll();
            int depth = polledNode.depth;
            int distance = polledNode.distance;

            dq.offer(new Node(depth+1, distance+1));
            dq.offer(new Node(depth+1, distance-1));
            dq.offer(new Node(depth+1, distance+5));
        }
        return dq.peek().depth;
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
