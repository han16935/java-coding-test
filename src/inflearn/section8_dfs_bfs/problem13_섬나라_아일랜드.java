package inflearn.section8_dfs_bfs;

import java.util.*;
import java.io.*;

public class problem13_섬나라_아일랜드 {

    static int n;
    static int answer;
    static int [][] map;
    static boolean [][] isVisited;

    static int [] dx = {0, 1, 1, 1, 0, -1, -1, -1}; // 12부터 시계방향
    static int [] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; // 12부터 시계방향

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1][n + 1];

        for(int y=1;y<=n;y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=1;x<=n;x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Point> queue = new ArrayDeque<>();

        for(int y=1;y<=n;y++) {
            for(int x=1;x<=n;x++) {

                if (!isVisited[y][x] && map[y][x] == 1) {
                    queue.offer(new Point(y, x));
                    while(!queue.isEmpty()) {
                        Point polledPoint = queue.poll();
                        if (isAlreadyVisited(polledPoint)) {
                            continue;
                        }

                        isVisited[polledPoint.y][polledPoint.x] = true;

                        for(int i=0;i<8;i++) {
                            int nextY = polledPoint.y + dy[i];
                            int nextX = polledPoint.x + dx[i];
                            if (isValidPoint(nextY, nextX) && map[nextY][nextX] == 1) {
                                queue.offer(new Point(nextY, nextX));
                            }
                        }
                    }

                    answer++;
                }

            }
        }

        System.out.println(answer);
    }

    private static boolean isAlreadyVisited(Point p) {
        return isVisited[p.y][p.x];
    }

    private static boolean isValidPoint(int nextY, int nextX) {
        if (nextY < 1 || nextY > n) return false;
        if (nextX < 1 || nextX > n) return false;
        return true;
    }


    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
