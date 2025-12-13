package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class N과M_15649_IMPORTANT {

    static int n, m;
    static int[] answer;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];
        isVisited = new boolean[n + 1];

        solution(0);
    }

    static void solution(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }

        else {
           for (int nextNum = 1; nextNum <= n; nextNum ++) {
               if (!isVisited[nextNum]) {
                   isVisited[nextNum] = true;
                   answer[count] = nextNum;
                   solution (count + 1);
                   isVisited[nextNum] = false;
               }
           }
        }
    }
}
