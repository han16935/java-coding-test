package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

/**
 * 이전에 푼 아일랜드 문제 응용, 사각형을 입력받고, 이후 BFS 를 통해 size 받기
 *
 */
public class 영역구하기_2583_IMPORTANT {
    static int m, n, k;
    static int[][] board;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};  // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0}; // 동, 남, 서, 북
    static PriorityQueue<Integer> areaPq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        isVisited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && !isVisited[i][j]) {
                    Deque<Point> dq = new ArrayDeque<>();
                    int area = 0;
                    dq.offer(new Point(j, i));
                    isVisited[i][j] = true;

                    while (!dq.isEmpty()) {
                        Point polledPoint = dq.poll();
                        area++;

                        for (int dir = 0; dir < 4; dir++) {
                            int nextX = polledPoint.x + dx[dir];
                            int nextY = polledPoint.y + dy[dir];

                            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                            if (isVisited[nextY][nextX] || board[nextY][nextX] == 1) continue;

                            dq.offer(new Point(nextX, nextY));
                            isVisited[nextY][nextX] = true;
                        }
                    }
                    areaPq.offer(area);
                }
            }
        }

        System.out.println(areaPq.size());
        StringBuilder sb = new StringBuilder();
        while (!areaPq.isEmpty()) {
            sb.append(areaPq.poll()).append(" ");
        }
        System.out.println(sb);
    }

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
