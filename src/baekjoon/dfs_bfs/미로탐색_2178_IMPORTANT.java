package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class 미로탐색_2178_IMPORTANT {
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static int [][] arr;
    static boolean [][] isVisited;
    static int [] dn = {-1, 0, 1, 0}; // 12, 3, 6, 9
    static int [] dm = {0, 1, 0, -1}; // 12, 3, 6, 9
    static Deque<Point> queue = new ArrayDeque<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        isVisited = new boolean[n + 1][m + 1];

        for (int row = 1; row <=n; row ++) {
            String line = br.readLine();
            for (int col = 0; col < m; col ++) {
                int num = line.charAt(col) - '0';
                arr[row][col+1] = num;
            }
        }

        isVisited[1][1] = true;
        queue.offer(new Point(1, 1, 1));
        while (!queue.isEmpty()) {
            Point polledPoint = queue.poll();
            if (polledPoint.n == n && polledPoint.m == m) {
                answer = Math.min(answer, polledPoint.count);
            }

            else {

                for (int i=0;i<4;i++) {
                    int nextN = polledPoint.n + dn[i];
                    int nextM = polledPoint.m + dm[i];
                    if (nextN < 0 || nextN > n || nextM < 0 || nextM > m) continue;
                    if (arr[nextN][nextM] == 0) continue;

                    if (!isVisited[nextN][nextM]) {
                        isVisited[nextN][nextM] = true; // offer 전에 check 함으로써 메모리 초과 방지
                        queue.offer(new Point(nextN, nextM, polledPoint.count + 1));
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static class Point {
        int n;
        int m;
        int count;

        public Point (int n, int m, int count) {
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }
}
