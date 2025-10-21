package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class 색종이붙이기_17136_IMPORTANT {

    static int answer = Integer.MAX_VALUE;

    static int [][] board = new int[10][10];
    static int [] paperCountArr = {0, 5, 5, 5, 5, 5}; // 0, 1*1, 2*2, ..., 5*5

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i=0;i<10;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<10;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void solution(int xy, int paperCount) {

        if (xy == 100) {
            answer = Math.min(answer, paperCount);
            return;
        }

        if (paperCount > answer) {
            return;
        }

        int x = xy / 10;
        int y = xy % 10;
        if (board[x][y] == 1) {
            for (int paperType = 5; paperType > 0; paperType--) {
                if (paperCountArr[paperType] > 0 && canFill(x, y, paperType)) {
                    paperCountArr[paperType]--;
                    fill(x, y, 0, paperType);
                    solution(xy + 1, paperCount + 1);
                    fill(x, y, 1, paperType);
                    paperCountArr[paperType]++;
                }
            }
        }

        else solution (xy + 1, paperCount);
    }

    static boolean canFill(int x1, int y1, int paperType) {
        if (x1 + paperType > 10 || y1 + paperType > 10) return false;

        for (int x = x1; x < x1 + paperType; x++) {
            for (int y = y1; y < y1 + paperType; y++) {
                if (board[x][y] == 0) return false;
            }
        }

        return true;
    }

    static void fill(int x1, int y1, int fillType, int paperType) {
        for (int x = x1; x < x1 + paperType; x++) {
            for (int y = y1; y < y1 + paperType; y++) {
                board[x][y] = fillType;
            }
        }
    }
}
