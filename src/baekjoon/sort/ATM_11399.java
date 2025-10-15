package baekjoon.sort;

import java.util.*;
import java.io.*;

public class ATM_11399 {

    static int n, answer;
    static int [] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int j=0;j<n;j++) {
            sum += arr[j];
            answer += sum;
        }

        System.out.println(answer);
    }
}
