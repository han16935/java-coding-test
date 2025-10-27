package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class 색종이붙이기_17136_IMPORTANT {

    static int answer = Integer.MAX_VALUE;
    static int [][] board = new int[10][10];
    static int [] paperCount = {0, 5, 5, 5, 5, 5};

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int row=0;row<10;row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col=0;col<10;col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }

        else System.out.println(answer);
    }

    static void solution(int xy, int count) {
        if (xy == 100) {
            answer = Math.min(answer, count);
        }

        else {
            int x = xy / 10;
            int y = xy % 10;

            if (count > answer) return;
            if (board[x][y] == 1) {
                for (int paperIndex=5;paperIndex>=1;paperIndex--) {
                    int paperSize = paperIndex;
                    if (canFill(x, y, paperSize)) {
                        fill(x, y, paperSize, 0);
                        paperCount[paperIndex]--;
                        solution(xy + 1, count + 1);
                        fill(x, y, paperSize, 1);
                        paperCount[paperIndex]++;
                    }
                }
            }

            else solution(xy + 1, count);
        }
    }

    static boolean canFill(int x, int y, int paperSize) {

        if (paperCount[paperSize] <= 0) return false;
        if (x + paperSize > 10 || y + paperSize > 10) return false;

        for (int row=x; row < x + paperSize;row++) {
            for (int col=y; col < y + paperSize;col++) {
                if(board[row][col] == 0) return false;
            }
        }

        return true;
    }

    static void fill(int x, int y, int paperSize, int fillType) {
        for (int row=x; row < x + paperSize;row++) {
            for (int col=y; col < y + paperSize;col++) {
                board[row][col] = fillType;
            }
        }
    }
}
