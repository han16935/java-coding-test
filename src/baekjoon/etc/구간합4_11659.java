package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 구간합4_11659 {
    static int n, m;
    static int [] arr;
    static int [] arrSum;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        arrSum = new int[n + 1];
        arrSum[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arrSum[i] = arrSum[i-1] + arr[i];
        }

        for (int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == end) {
                System.out.println(arr[start]);
                continue;
            }

            if (start == 1) {
                System.out.println(arrSum[end]);
                continue;
            }

            System.out.println(arrSum[end] - arrSum[start - 1]);
        }
    }
}
