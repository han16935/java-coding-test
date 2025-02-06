package inflearn.section7_recursive_tree_graph;

import java.util.*;

public class problem11_경로탐색_인접행렬 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n+1][n+1];
        boolean [] isVisited = new boolean[n+1];

        for(int i=0;i<m;i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            arr[start][end] = 1;
        }
        isVisited[1] = true;
        solution(n, 1, arr, isVisited);
        System.out.println(answer);
    }

    private static void solution(int n, int currentPos, int [][] arr, boolean[] isVisited) {
        if (currentPos == n) answer++;
        else {
            for(int place=1;place<=n;place++) {
                if (!isVisited[place] && arr[currentPos][place] == 1) {
                    isVisited[place] = true;
                    solution(n, place, arr, isVisited);
                    isVisited[place] = false;
                }
            }
        }
    }
}
