package baekjoon.segment;

import java.util.*;
import java.io.*;


/**
 * leaf node 대해서만 mod 연산 실행 시, 나머지 최댓값이 1,000,000,006 ^ 2 이므로 계속 반복되면 overflow 발생!
 *
 */
public class 구간곱구하기_11505_IMPORTANT {

    private static final int MOD = 1000000007;
    static int n, m, k;
    static int [] arr;
    static long [] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        tree = new long[4 * (n + 1)];

        for (int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 1, n);

        for (int j=0;j<m+k;j++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());

            if (type == 1) { // arr[firstNum] = secondNum;
                update(1, 1, n, firstNum, secondNum);
            }

            if (type == 2) { // firstNum ~ secondNum 곱 % MOD
                bw.write(query(1, 1, n, firstNum, secondNum) % MOD + "\n");
            }
        }
        bw.flush();
    }

    static void init (int nodeIndex, int startRange, int endRange) {
        if (startRange == endRange) {
            tree[nodeIndex] = arr[startRange] % MOD;
        }

        else {
            int mid = (startRange + endRange) / 2;
            init(nodeIndex * 2, startRange, mid);
            init(nodeIndex * 2 + 1, mid + 1, endRange);
            tree[nodeIndex] = tree[nodeIndex * 2] * tree[nodeIndex * 2 + 1] % MOD;
        }
    }

    static void update (int nodeIndex, int nodeStartRange, int nodeEndRange, int targetIndex, int newValue) {
        if (nodeStartRange == targetIndex && nodeEndRange == targetIndex) {
            tree[nodeIndex] = newValue % MOD;
        }

        else {
            int mid = (nodeStartRange + nodeEndRange) / 2;
            if (targetIndex <= mid) update(nodeIndex * 2, nodeStartRange, mid, targetIndex, newValue);
            else update(nodeIndex * 2 + 1, mid + 1, nodeEndRange, targetIndex, newValue);
            tree[nodeIndex] = tree[nodeIndex * 2] * tree[nodeIndex * 2 + 1] % MOD;
        }
    }

    static long query(int nodeIndex, int nodeStartRange, int nodeEndRange, int queryStartRange, int queryEndRange) {

        // 전체 불포함
        if (queryEndRange < nodeStartRange || nodeEndRange < queryStartRange) return 1;

        // 전체 포함
        if (queryStartRange <= nodeStartRange && nodeEndRange <= queryEndRange) {
            return tree[nodeIndex];
        }

        int mid = (nodeStartRange + nodeEndRange) / 2;
        long ltResult = query(nodeIndex * 2, nodeStartRange, mid, queryStartRange, queryEndRange);
        long rtResult = query(nodeIndex * 2 + 1, mid + 1, nodeEndRange, queryStartRange, queryEndRange);
        return ltResult * rtResult % MOD;
    }
}
