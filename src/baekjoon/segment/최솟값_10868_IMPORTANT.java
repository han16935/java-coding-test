package baekjoon.segment;

import java.util.*;
import java.io.*;

public class 최솟값_10868_IMPORTANT {

    static int n, m;
    static int [] arr;
    static int [] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        tree = new int[4 * (n + 1)];
        for (int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 1, n);

        for (int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(query(1, 1, n, start, end) + "\n");
        }
        bw.flush();
    }

    static void init (int nodeIndex, int nodeStartRange, int nodeEndRange) {

        if (nodeStartRange == nodeEndRange) tree[nodeIndex] = arr[nodeStartRange];
        else {
            int mid = (nodeStartRange + nodeEndRange) / 2;
            init(nodeIndex * 2, nodeStartRange, mid);
            init(nodeIndex * 2 + 1, mid + 1, nodeEndRange);
            tree[nodeIndex] = Math.min(tree[nodeIndex * 2], tree[nodeIndex * 2 + 1]);
        }
    }

    static int query (int nodeIndex, int nodeStartRange, int nodeEndRange, int queryStartRange, int queryEndRange) {

        if (nodeEndRange < queryStartRange || queryEndRange < nodeStartRange) return Integer.MAX_VALUE;
        if (queryStartRange <= nodeStartRange && nodeEndRange <= queryEndRange) return tree[nodeIndex];

        int mid = (nodeStartRange + nodeEndRange) / 2;
        int ltMin = query(nodeIndex * 2, nodeStartRange, mid, queryStartRange, queryEndRange);
        int rtMin = query(nodeIndex * 2 + 1, mid + 1, nodeEndRange, queryStartRange, queryEndRange);
        return Math.min(ltMin, rtMin);
    }
}
