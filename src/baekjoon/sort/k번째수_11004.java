package baekjoon.sort;

import java.util.*;
import java.io.*;

// 백준에서 new int[n+1] 로 하면 터짐...
public class k번째수_11004 {
    static int n, k;
    static long [] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(arr[k-1]);
    }
}
