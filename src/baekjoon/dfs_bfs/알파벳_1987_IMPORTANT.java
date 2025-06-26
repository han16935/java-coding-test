package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;


/**
 * 세로 R칸, 가로 C칸으로 된 표에서 좌상단 시작 + 이미 지난 알파벳이 적힌 칸은 두 번 지날 수 없을 경우
 * 최대 몇 칸 지날 수 있는 지 작성하기 ('최대' 안에는 좌측 상단의 칸도 포함!)
 *
 *     - 크게 어려운 문제... 인 줄 알았으나 백준 80퍼에서 막혀버려서 퍼플렉시티의 도움 받음;;
 *       else 문 내에도 answer 갱신을 넣어서 해결! 그 이유는 다음과 같음
 *           A B C     - 순서대로 돌아서 I에 다다를 경우, 상하좌우 모두 방문한 적이 잇으므로
 *           H I D       answer 의 값이 갱신되지 않음!! << 이걸 어케 알아
 *           G F E
 *
 */
public class 알파벳_1987_IMPORTANT {

    static int r;
    static int c;
    static int answer = 1;
    static char [][] board;
    static boolean [][] isVisited;
    static int [] dx = {0, 1, 0, -1}; // 12 3 6 9
    static int [] dy = {-1, 0, 1, 0}; // 12 3 6 9
    static Map<Character, Integer> map = new HashMap<>();

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        isVisited = new boolean[r][c];

        for(int i=0;i<r;i++) {
            String alphabet = br.readLine();
            for (int j=0;j<c;j++) {
                board[i][j] = alphabet.charAt(j);
                if (!map.keySet().contains(alphabet.charAt(j))) {
                    map.put(alphabet.charAt(j), 0);
                }
            }
        }

        solution(0, 0, 1);
        System.out.println(answer);
    }

    static void solution(int y, int x, int length) {
        if (map.get(board[y][x]) == 1) {
            answer = Math.max(answer, length - 1);
        }

        else {
            answer = Math.max(answer, length);
            map.put(board[y][x], map.get(board[y][x]) + 1);
            isVisited[y][x] = true;

            for(int i=0;i<4;i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextY >= r) continue;
                if (nextX < 0 || nextX >= c) continue;

                if (!isVisited[nextY][nextX]) {
                    solution(nextY, nextX, length + 1);
                }
            }

            map.put(board[y][x], map.get(board[y][x]) - 1);
            isVisited[y][x] = false;
        }
    }
}
