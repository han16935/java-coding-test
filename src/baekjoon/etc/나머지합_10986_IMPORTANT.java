package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 나머지합_10986_IMPORTANT {

    static int n, m;
    static long answer;
    static long [] arr;
    static long [] sumArr;
    static int [] restArr; // 0~m-1 index로

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];
        sumArr = new long[n];
        restArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        sumArr[0] = arr[0];
        for (int j=1;j<n;j++) {
            sumArr[j] = sumArr[j-1] + arr[j];
        }

        for (int k=0;k<n;k++) {
            int rest = (int) (sumArr[k] % m);
            restArr[rest]++;

            if (rest == 0) answer++;
        }

        for (int rest=0;rest<m;rest++) {
            if (restArr[rest] > 1) answer += combination(restArr[rest]);
        }

        System.out.println(answer);
    }

    static long combination(int value) {
        return (long) value * (value - 1) / 2;
    }
}
