package baekjoon.segment;

import java.util.*;
import java.io.*;

public class 구간합구하기_2042_IMPORTANT {

    static int n, m, k;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        tree = new long[4 * (n + 1)];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1, 1, n);

        for (int j = 0; j < m + k; j++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int firstTarget = Integer.parseInt(st.nextToken());
            long secondTarget = Long.parseLong(st.nextToken()); // c는 -2^63 ~ 2^63-1 범위 내이므로 long으로
            if (type == 1) {
                update(1, 1, n, firstTarget, secondTarget);
            }

            if (type == 2) {
                bw.write(query(1, 1, n, firstTarget, secondTarget) + "\n");
            }
        }
        bw.flush();
    }

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static void update(int node, int start, int end, int targetIndex, long newValue) {

        if (start == end) tree[node] = newValue;

        else {
            int mid = (start + end) / 2;
            if (targetIndex <= mid) update(node * 2, start, mid, targetIndex, newValue);
            else update(node * 2 + 1, mid + 1, end, targetIndex, newValue);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static long query(int node, int startNodeRange, int endNodeRange,
                      int startSumRange, long endSumRange) {

        // node 범위 내 완전 포함
        if (startSumRange <= startNodeRange && endNodeRange <= endSumRange) {
            return tree[node];
        }

        // 완전 불포함
        if (endSumRange < startNodeRange || endNodeRange < startSumRange) {
            return 0;
        }

        int mid = (startNodeRange + endNodeRange) / 2;
        long leftSum = query(node * 2, startNodeRange, mid, startSumRange, endSumRange);
        long rightSum = query(node * 2 + 1, mid + 1, endNodeRange, startSumRange, endSumRange);
        return leftSum + rightSum;
    }
}
