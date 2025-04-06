package inflearn.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출발지도 방문 체크해주기;;
 */
public class problem10_미로탐색_DFS {

    static int [][] boards = new int[8][8];
    static boolean [][] isVisited = new boolean[8][8];
    static int [] dx = {0, 0, -1, 1}; // 상하좌우
    static int [] dy = {-1, 1, 0, 0}; // 상하좌우
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                boards[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isVisited[1][1] = true;
        solution(1, 1);
        System.out.println(answer);
    }

    public static void solution(int y, int x) {
        if (x == 7 && y == 7) {
            answer++;
        }

        else {
            for(int i=0;i<4;i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if (isValidPoint(nextY, nextX) && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true;
                    solution(nextY, nextX);
                    isVisited[nextY][nextX] = false;
                }
            }
        }
    }

    private static boolean isValidPoint(int nextY, int nextX) {
        if (nextY < 1 || nextY > 7) return false;
        if (nextX < 1 || nextX > 7) return false;
        if (boards[nextY][nextX] == 1) return false;
        return true;
    }
}
