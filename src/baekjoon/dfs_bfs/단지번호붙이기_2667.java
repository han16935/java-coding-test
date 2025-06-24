package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class 단지번호붙이기_2667 {
    static int n;
    static int [][] board;
    static boolean [][] isVisited;
    static int [] dx = {0, 1, 0, -1}; // 12 3 6 9
    static int [] dy = {-1, 0, 1, 0}; // 12 3 6 9

    public static void main (String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        isVisited = new boolean[n][n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0;i<n;i++) {
            String homeLine = br.readLine();
            for (int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(String.valueOf(homeLine.charAt(j)));
            }
        }

        for (int y=0;y<n;y++) {
            for (int x=0;x<n;x++) {

                if (board[y][x] == 1 && !isVisited[y][x]) {

                    Deque<Point> dq = new ArrayDeque<>();
                    dq.offer(new Point(x, y));
                    int size = 0;

                    while(!dq.isEmpty()) {
                        Point polledPoint = dq.poll();
                        if (polledPoint.isAlreadyVisited()) continue;
                        polledPoint.setVisited();
                        size++;

                        for (int directionCount = 0; directionCount < 4; directionCount++) {
                            int nextY = polledPoint.y + dy[directionCount];
                            int nextX = polledPoint.x + dx[directionCount];

                            if (nextY < 0 || nextY >= n) continue;
                            if (nextX < 0 || nextX >= n) continue;

                            if (board[nextY][nextX] == 1 && !isVisited[nextY][nextX]) {
                                Point nextPoint = new Point(nextX, nextY);
                                dq.offer(nextPoint);
                            }
                        }
                    }
                    pq.offer(size);
                }
            }
        }

        System.out.println(pq.size());
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setVisited() {
            isVisited[y][x] = true;
        }

        public boolean isAlreadyVisited() {
            return isVisited[y][x];
        }
    }
}
