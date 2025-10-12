package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 나머지합_10986_IMPORTANT {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arrSum = new long[n];
        int[] reminder = new int[m];

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            arrSum[i] = sum % m;
            reminder[(int) arrSum[i]]++;
        }

        // 구간합이 m으로 나누어떨어진 경우 (누적합 나머지 0)
        answer += reminder[0];

        // 같은 나머지가 나온 쌍의 조합
        for (int v = 0; v < m; v++) {
            if (reminder[v] >= 2) {
                answer += (long) reminder[v] * (reminder[v] - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}
