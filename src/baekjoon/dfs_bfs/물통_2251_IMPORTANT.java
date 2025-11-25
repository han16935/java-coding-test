package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class 물통_2251_IMPORTANT {
    static int [] capacity = new int[3];
    static int maxCapacity;
    static boolean [][][] isVisited;
    static boolean [] isAnswer;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<3;i++) {
            capacity[i] = Integer.parseInt(st.nextToken());
        }
        maxCapacity = capacity[2];
        isVisited = new boolean[capacity[0] + 1][capacity[1] + 1][capacity[2] + 1];
        isAnswer = new boolean[maxCapacity + 1];

        isVisited[0][0][capacity[2]] = true;
        dfs(0, 0, capacity[2]);

        for (int i=0;i< isAnswer.length;i++) {
            if (isAnswer[i]) bw.write(i + " ");
        }
        bw.flush();
    }

    static void dfs (int a, int b, int c) {

        if (a == 0) isAnswer[c] = true;

        int amount = 0;
        int nextA = 0;
        int nextB = 0;
        int nextC = 0;

        if (a > 0) {
            // a -> b
            amount = Math.min(capacity[1] - b, a);
            nextA = a - amount;
            nextB = b + amount;
            if (!isVisited[nextA][nextB][c]) {
                isVisited[nextA][nextB][c] = true;
                dfs (nextA, nextB, c);
            }

            // a -> c
            amount = Math.min(capacity[2] - c, a);
            nextA = a - amount;
            nextC = c + amount;
            if (!isVisited[nextA][b][nextC]) {
                isVisited[nextA][b][nextC] = true;
                dfs (nextA, b, nextC);
            }
        }

        if (b > 0) {
            // b -> a
            amount = Math.min(capacity[0] - a, b);
            nextB = b - amount;
            nextA = a + amount;
            if (!isVisited[nextA][nextB][c]) {
                isVisited[nextA][nextB][c] = true;
                dfs (nextA, nextB, c);
            }

            // b -> c
            amount = Math.min(capacity[2] - c, b);
            nextB = b - amount;
            nextC = c + amount;
            if (!isVisited[a][nextB][nextC]) {
                isVisited[a][nextB][nextC]= true;
                dfs (a, nextB, nextC);
            }
        }

        if (c > 0) {
            // c -> a
            amount = Math.min(capacity[0] - a, c);
            nextC = c - amount;
            nextA = a + amount;
            if (!isVisited[nextA][b][nextC]) {
                isVisited[nextA][b][nextC] = true;
                dfs (nextA, b, nextC);
            }

            // c -> b
            amount = Math.min(capacity[1] - b, c);
            nextC = c - amount;
            nextB = b + amount;
            if (!isVisited[a][nextB][nextC]) {
                isVisited[a][nextB][nextC] = true;
                dfs (a, nextB, nextC);
            }
        }
    }
}
