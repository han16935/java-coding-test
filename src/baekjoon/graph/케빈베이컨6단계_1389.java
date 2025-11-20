package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 케빈베이컨6단계_1389 {
    static int n, m;
    static int [][] dis;
    static int answer;
    static int answerCount = Integer.MAX_VALUE;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis = new int[n + 1][n + 1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (i == j) dis[i][j] = 0;
                else dis[i][j] = 1000001;
            }
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dis[start][end] = 1;
            dis[end][start] = 1;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    dis[start][end] =
                            Math.min(dis[start][end], dis[start][mid] + dis[mid][end]);
                }
            }
        }

        for (int person = 1; person <= n; person++) {
            int personCount = 0;
            for (int other = 1; other <= n; other++) {
                personCount += dis[person][other];
            }

            if (personCount < answerCount) {
                answerCount = personCount;
                answer = person;
            }
        }

        System.out.println(answer);
    }
}
