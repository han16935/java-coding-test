package inflearn.section5_stack_queue;

import java.util.*;
import java.io.*;

public class problem3_크레인인형뽑기_important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int k = 1; k <= m; k++) {
            moves[k] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, board, m, moves));

    }

    private static int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        int[] lastDollPosition = new int[n + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int moveCnt = 1; moveCnt <= m; moveCnt++) {
            // 1. moves[moveCnt] 라인의 제일 위 인형 번호 구하기
            int dollNum = 0;
            int nextDollLine = moves[moveCnt]; // board의 line번 인형 가져올 거임

            if (lastDollPosition[nextDollLine] == n + 1) continue;

            if (lastDollPosition[nextDollLine] == 0) {
                for (int row = 1; row <= n; row++) {
                    if (board[row][nextDollLine] != 0) {
                        dollNum = board[row][nextDollLine];
                        board[row][nextDollLine] = 0;
                        lastDollPosition[nextDollLine] = row + 1;
                        break;
                    }
                }
            }

            else {
                int row = lastDollPosition[nextDollLine];
                dollNum = board[row][nextDollLine];
                board[row][nextDollLine] = 0;
                lastDollPosition[nextDollLine] = row + 1;
            }

            // 2. 바구니에 넣기 전, 터뜨려야 하는 지 확인
            if (dq.size() > 0 && dq.peekLast() == dollNum) {
                answer += 2;
                dq.removeLast();
            }
            else dq.addLast(dollNum);
        }
        return answer;
    }
}

