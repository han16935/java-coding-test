package baekjoon.union;

import java.util.*;
import java.io.*;

public class 집합의표현_1717 {
    static int n, m;
    static int [] union;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        union = new int[n + 1];
        for (int i=1;i<=n;i++) {
            union[i] = i;
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int firstSet = Integer.parseInt(st.nextToken());
            int secondSet = Integer.parseInt(st.nextToken());
            if (type == 0) union(firstSet, secondSet);
            else {
                if (find(firstSet) == find(secondSet)) bw.write("YES" + "\n");
                else bw.write("NO" + "\n");
            }
        }

        bw.flush();
    }

    static void union(int first, int second) {
        int firstSet = find(first);
        int secondSet = find(second);
        if (firstSet != secondSet) union[firstSet] = secondSet;
    }

    static int find(int num) {
        if (union[num] == num) return num;
        else return union[num] = find(union[num]);
    }
}
