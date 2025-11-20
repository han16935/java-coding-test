package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 경로찾기_11403 {
    static int n;
    static int [][] route;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        route = new int[n][n];

        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                int r = Integer.parseInt(st.nextToken());
                route[i][j] = r;
            }
        }

        for (int mid=0;mid<n;mid++) {
            for (int start = 0; start < n; start++) {
                for (int end = 0; end < n; end++) {
                    if (route[start][mid] == 1 && route[mid][end] == 1) {
                        route[start][end] = 1;
                    }
                }
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                bw.write(route[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
