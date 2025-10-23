package baekjoon.binarysearch;

import java.util.*;
import java.io.*;

public class 수찾기_1920 {
    static int n, m;
    static int [] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int j=0;j<m;j++) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(binarySearch(num)) + "\n");
        }
        bw.flush();
    }

    static int binarySearch(int num) {

        int lt = 0;
        int rt = n - 1;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            if (arr[mid] == num || arr[lt] == num || arr[rt] == num) {
                return 1;
            }

            else if (num < arr[mid]) {
                rt = mid - 1;
            }

            else if (arr[mid] < num) {
                lt = mid + 1;
            }
        }

        return 0;
    }
}
