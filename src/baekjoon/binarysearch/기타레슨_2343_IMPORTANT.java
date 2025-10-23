package baekjoon.binarysearch;

import java.util.*;
import java.io.*;

public class 기타레슨_2343_IMPORTANT {

    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static int [] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        for (int j=0;j<n;j++) {
            lt = Math.max(lt, arr[j]);
            rt += arr[j];
        }

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = 0; // 이 경우에서의 디스크 수
            int tmpDiscStorage = 0;
            for (int k=0;k<n;k++) {

                if (mid < tmpDiscStorage + arr[k]) {
                    count++;
                    tmpDiscStorage = 0;
                }

                if (count > m) break;

                if (count <= m) {
                    tmpDiscStorage += arr[k];
                }
            }

            if (tmpDiscStorage <= mid) count++;

            if (count <= m) {
                answer = Math.min(answer, mid);
                rt = mid - 1;
            }

            else lt = mid + 1;
        }

        System.out.println(answer);
    }
}
