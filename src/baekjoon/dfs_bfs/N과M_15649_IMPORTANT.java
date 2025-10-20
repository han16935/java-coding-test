package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class N과M_15649_IMPORTANT {

    static int n, m;
    static boolean[] isVisited;
    static int[] answer;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n + 1];
        answer = new int[m];

        solution(0);
        bw.flush();
        bw.close();
    }

    static void solution(int depth) throws Exception {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(answer[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                answer[depth] = i;
                solution(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
