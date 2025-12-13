package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class 스도쿠_2580_IMPORTANT {

    static int [][] board = new int[9][9];
    static boolean [][] isVisited = new boolean[9][9];
    static int emptyBoardCount = 0;
    static boolean answerDecided = false;
    static int [] dx = {0, 1, 0, -1}; // 12 3 6 9
    static int [] dy = {-1, 0, 1, 0}; // 12 3 6 9

    public static void main(String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<9;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) emptyBoardCount++;
            }
        }

        solution(0, 0, emptyBoardCount);

        for (int i=0;i<9;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<9;j++) {
                sb.append(board[i][j] + " ");
            }
            System.out.println(sb);
        }
    }

    static void solution(int y, int x, int emptyBoardCount) {
        if (answerDecided) return;

        if (emptyBoardCount == 0) {

            // 가로선 비교
            for(int colY=0;colY<9;colY++) {
                int tmp = 0;
                for(int colX=0;colX<9;colX++) {
                    tmp += board[colY][colX];
                    if (tmp > 45) return;
                }
                if (tmp != 45) return;
            }

            // 세로선 비교
            for(int rowX=0;rowX<9;rowX++) {
                int tmp = 0;
                for(int rowY=0;rowY<9;rowY++) {
                    tmp += board[rowY][rowX];
                    if (tmp > 45) return;
                }
                if (tmp != 45) return;
            }

            // 각 사각형 비교
            for (int squareY=0;squareY<9;squareY+=3) {
                for (int squareX=0;squareX<9;squareX+=3) {
                    int tmp = 0;
                    for (int yInSquare=squareY;yInSquare<squareY+3;yInSquare++) {
                        for (int xInSquare=squareX;xInSquare<squareX+3;xInSquare++) {
                            tmp += board[yInSquare][xInSquare];
                            if (tmp > 45) return;
                        }
                    }
                    if (tmp != 45) return;
                }
            }
            answerDecided = true;
        }

        else {

            isVisited[y][x] = true;

            for (int nextRange = 0; nextRange < 4; nextRange++) {
                if (board[y][x] == 0) {
                    for (int nextNumber = 1; nextNumber<=9;nextNumber++) {
                        board[y][x] = nextNumber;
                        for (int range = 0; range < 4;range++) {
                            int nextY = y + dy[range];
                            int nextX = x + dx[range];

                            if (nextY < 0 || nextY >= 9) continue;
                            if (nextX < 0 || nextX >= 9) continue;

                            if (!isVisited[nextY][nextX]) {
                                solution(nextY, nextX, emptyBoardCount-1);
                            }
                        }
                    }
                }

                else {
                    for (int range = 0; range < 4;range++) {
                        int nextY = y + dy[range];
                        int nextX = x + dx[range];

                        if (nextY < 0 || nextY >= 9) continue;
                        if (nextX < 0 || nextX >= 9) continue;

                        if (!isVisited[nextY][nextX]) {
                            solution(nextY, nextX, emptyBoardCount-1);
                        }
                    }
                }
            }
        }
    }
}
