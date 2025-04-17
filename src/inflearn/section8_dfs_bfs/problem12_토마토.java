package inflearn.section8_dfs_bfs;

import java.util.*;
import java.io.*;

/**
 * m이 가로, n이 세로
 * 입력받을 때 익지 않은 (0) 토마토 개수 세기
 * 입력받을 때 익은 (1) 토마토 queue에 날짜 0과 함께 넣기
 * queue가 다 비었을 때, 익지 않은 토마토 개수가 0보다 크면 -1 return
 * 익지 않은 토마토 개수가 0이면 0 return
 */
public class problem12_토마토 {

    static int m, n;
    static int [][] tomatoes;
    static int [][] daysToRippenTomatoes; // daysToRippenTomatoes[y][x] = num (y, x) 토마토가 익는 데 num 일 걸림
    static int [] dx = {0, 0, -1, 1}; // 상하좌우
    static int [] dy = {-1, 1, 0, 0}; // 상하좌우
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomatoes = new int[n+1][m+1];
        daysToRippenTomatoes = new int[n + 1][m + 1];

        Deque<Tomato> queue = new ArrayDeque<>();
        boolean isAllTomatoesAreAlreadyRippen = true;
        for(int y=1;y<=n;y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=1;x<=m;x++) {
                tomatoes[y][x] = Integer.parseInt(st.nextToken());
                if (isAllTomatoesAreAlreadyRippen && tomatoes[y][x] == 0) {
                    isAllTomatoesAreAlreadyRippen = false;
                }

                if (tomatoes[y][x] == 1) queue.offer(Tomato.createInitialTomato(y, x));
            }
        }

        if (isAllTomatoesAreAlreadyRippen) {
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()) {
            Tomato polledTomato = queue.poll();
            daysToRippenTomatoes[polledTomato.y][polledTomato.x] = polledTomato.day;

            for(int range=0;range<4;range++) {
                int nextY = polledTomato.y + dy[range];
                int nextX = polledTomato.x + dx[range];

                if (isValidPosition(nextY, nextX) && tomatoes[nextY][nextX] == 0) {
                    queue.offer(polledTomato.passNextDay(nextY, nextX));
                    tomatoes[nextY][nextX] = 1;
                }
            }
        }

        boolean cannotReachToUnrippenTomatoes = false;
        for(int y=1;y<=n;y++) {
            for(int x=1;x<=m;x++) {
                if (tomatoes[y][x] == 0) {
                    cannotReachToUnrippenTomatoes = true;
                    break;
                }
                answer = Math.max(answer, daysToRippenTomatoes[y][x]);
            }
        }

        if (cannotReachToUnrippenTomatoes) {
            System.out.println(-1);
            return;
        }


        System.out.println(answer);
    }

    private static boolean isValidPosition(int nextY, int nextX) {
        if (nextY < 1 || nextY > n) return false;
        if (nextX < 1 || nextX > m) return false;
        return true;
    }


    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }

        public static Tomato createInitialTomato(int y, int x) {
            return new Tomato(y, x, 0);
        }

        public Tomato passNextDay(int y, int x) {
            return new Tomato(y, x, day + 1);
        }
    }
}
