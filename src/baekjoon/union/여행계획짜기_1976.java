package baekjoon.union;

import java.util.*;
import java.io.*;

public class 여행계획짜기_1976 {
    static int n, m;
    static int [] plan;
    static int [] sets;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sets = new int[n + 1];
        for (int i=0;i<=n;i++) {
            sets[i] = i;
        }

        m = Integer.parseInt(br.readLine());
        plan = new int[m];

        StringTokenizer st;
        for (int start=1;start<=n;start++) {
            st = new StringTokenizer(br.readLine());
            for (int end=1;end<n;end++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(start, end);
                }
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int j=0;j<m;j++) {
            plan[j] = Integer.parseInt(st.nextToken());
        }

        for (int k=0;k<m-1;k++) {
            if (find(plan[k]) != find(plan[k+1])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static int find (int node) {
        if (node == sets[node]) return node;
        else return sets[node] = find(sets[node]);
    }

    static void union (int first, int second) {
        int firstSetParent = find(first);
        int secondSetParent = find(second);
        if (firstSetParent != secondSetParent) sets[firstSetParent] = secondSetParent;
    }
}
