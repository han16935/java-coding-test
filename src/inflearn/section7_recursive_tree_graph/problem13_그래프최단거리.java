package inflearn.section7_recursive_tree_graph;

import java.util.*;

public class problem13_그래프최단거리 {

    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static Deque<Node> dq = new ArrayDeque<>();
    static boolean [] isVisited;
    static int [] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        isVisited = new boolean[n+1];
        answer = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for(int i=0;i<=n;i++) {
            arr.add(new ArrayList<>());
        }
        for(int j=0;j<m;j++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            arr.get(start).add(end);
        }

        dq.offer(new Node(0, 1));
        solution();

        for(int k=2;k<=n;k++) {
            System.out.println(k + " : " + answer[k]);
        }
    }

    private static void solution() {
        while(!dq.isEmpty()) {
            Node currentPosNode = dq.poll();
            int currentPos = currentPosNode.node;
            int dis = currentPosNode.dis;

            if (dis < answer[currentPos]) {
                answer[currentPos] = dis;
            }

            isVisited[currentPos] = true;

            for(int nextDestination : arr.get(currentPos)) {
                if (!isVisited[nextDestination]) dq.offer(new Node(dis+1, nextDestination));
            }
        }
    }

    static class Node {
        int dis;
        int node;

        public Node(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }
    }
}
