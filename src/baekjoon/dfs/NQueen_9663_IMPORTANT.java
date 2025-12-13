package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class NQueen_9663_IMPORTANT {

    static int n, answer;
    static int [] isVisitedRow; // 특정 row의 몇 번째 col이 사용중인 지

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        isVisitedRow = new int[n];
        Arrays.fill(isVisitedRow, -1);

        solution(0);

        System.out.println(answer);
    }

    static void solution(int row) {
        if (row == n) {
            answer++;
        }

        else {
            for (int nextCol=0;nextCol<n;nextCol++) {
                if (isFreeCol(row, nextCol)) {
                    isVisitedRow[row] = nextCol;
                    solution(row + 1);
                    isVisitedRow[row] = -1;
                }
            }
        }
    }

    static boolean isFreeCol(int row, int col) {

        for (int row2=0; row2<n && row2 != row; row2++) {
            // 타 row에 이 col을 쓰는 게 있는지?
            if (isVisitedRow[row2] == col) return false;

            // 특정 row, col 위치에 대각선으로 위치가 같은 게 있는지?
            if (Math.abs(row2 - row) == Math.abs(col - isVisitedRow[row2])) return false;
        }

        return true;
    }
}
