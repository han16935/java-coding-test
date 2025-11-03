package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 플로이드_11404_IMPORTANT {

    private static final int MAX_DISTANCE = Integer.MAX_VALUE / 2;
    static int n, m;
    static int [][] answer;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        answer = new int[n + 1][n + 1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (i == j) answer[i][j] = 0;
                else answer[i][j] = MAX_DISTANCE;
            }
        }

        for (int j=0;j<m;j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (weight < answer[start][end]) answer[start][end] = weight;
        }

        for (int k=1;k<=n;k++) {
            for (int start=1;start<=n;start++) {
                for (int end=1;end<=n;end++) {

                    // MAX_DISTANCE 통해 overflow 방지
                    if (answer[start][k] != MAX_DISTANCE && answer[k][end] != MAX_DISTANCE) {
                        answer[start][end] = Math.min(answer[start][end], answer[start][k] + answer[k][end]);
                    }

                }
            }
        }

        for (int k=1;k<=n;k++) {
            for (int l=1;l<=n;l++) {
                if (answer[k][l] == MAX_DISTANCE) bw.write(0 + " ");
                else bw.write(answer[k][l] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
