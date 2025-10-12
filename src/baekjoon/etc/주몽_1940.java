package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 주몽_1940 {
    static int n;
    static int m;
    static int answer;
    static int [] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int lt = 0; lt < n; lt++) {
            for (int rt = lt + 1; rt < n; rt++) {
                if (arr[lt] + arr[rt] >= m) {
                    if (arr[lt] + arr[rt] == m) answer++;
                    continue;
                }
            }
        }
        bw.write(String.valueOf(answer) + "\n");
        bw.flush();
    }
}
