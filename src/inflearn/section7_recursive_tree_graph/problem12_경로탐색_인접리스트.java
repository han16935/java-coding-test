package inflearn.section7_recursive_tree_graph;

import java.util.*;

public class problem12_경로탐색_인접리스트 {

    static int n;
    static int m;
    static int answer = 0;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        isVisited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int j = 0; j < m; j++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            arr.get(start).add(end);
        }

        isVisited[1] = true;
        solution(1);
        System.out.println(answer);
    }

    private static void solution(int currentPos) {
        if (currentPos == n) answer++;
        else {
            ArrayList<Integer> availableNodes = arr.get(currentPos);
            for (int i = 0; i < availableNodes.size(); i++) {
                Integer availableNode = availableNodes.get(i);
                if (!isVisited[availableNode]) {
                    isVisited[availableNode] = true;
                    solution(availableNode);
                    isVisited[availableNode] = false;
                }
            }
        }
    }
}
