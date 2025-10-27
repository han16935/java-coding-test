package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class 미로탐색_2178_IMPORTANT {

    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static int [][] board;
    static int [] dn = {-1, 0, 1, 0}; // 12, 3, 6, 9
    static int [] dm = {0, 1, 0, -1}; // 12, 3, 6, 9
    static Deque<Node> queue = new ArrayDeque<>();
    static boolean [][] isVisited;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i=0;i<n;i++) {
            String str = br.readLine();
            for (int j=0;j<m;j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        isVisited[0][0] = true;
        queue.offer(new Node(0, 0, 1));
        while (!queue.isEmpty()) {

            Node polledNode = queue.poll();
            if (polledNode.n == n-1 && polledNode.m == m-1) {
                answer = Math.min(answer, polledNode.count);
            }

            for (int i=0;i<4;i++) {
                int nextN = polledNode.n + dn[i];
                int nextM = polledNode.m + dm[i];

                if (nextN < 0 || nextN >= n || nextM < 0 || nextM >= m) continue;
                if (!isVisited[nextN][nextM] && board[nextN][nextM] == 1) {
                    isVisited[nextN][nextM] = true;
                    queue.offer(new Node(nextN, nextM, polledNode.count + 1));
                }
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int n;
        int m;
        int count;

        public Node (int n, int m, int count) {
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }
}
