package inflearn.section8_dfs_bfs;

import java.io.*;
import java.util.*;

public class problem11_미로최단거리통로_BFS {


    static int[][] boards = new int[8][8];
    static boolean[][] isVisited = new boolean[8][8];
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Point> queue = new ArrayDeque<>();
        isVisited[1][1] = true;
        queue.offer(new Point(1, 1, 0));
        while(!queue.isEmpty()) {
            Point polledPoint = queue.poll();

            if (polledPoint.isArrivalPoint()) {
                if (answer == -1) answer = polledPoint.distance;
                else answer = Math.min(answer, polledPoint.distance);
            }

            else {
               for (int i=0;i<4;i++) {
                   int nextY = polledPoint.y + dy[i];
                   int nextX = polledPoint.x + dx[i];
                   if (isValidPoint(nextY, nextX) && !isVisited[nextY][nextX]) {
                       isVisited[nextY][nextX] = true;
                       queue.offer(polledPoint.createNextPoint(nextY, nextX));
                   }
               }
            }
        }

        System.out.println(answer);
    }

    private static boolean isValidPoint(int nextY, int nextX) {
        if (nextY < 1 || nextY > 7) return false;
        if (nextX < 1 || nextX > 7) return false;
        if (boards[nextY][nextX] == 1) return false;
        return true;
    }

    static class Point {
        int y;
        int x;
        int distance;

        public Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        public Point createNextPoint(int y, int x) {
            return new Point(y, x, this.distance + 1);
        }

        public boolean isArrivalPoint() {
            return y == 7 && x == 7;
        }
    }
}
