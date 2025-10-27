package baekjoon.binarysearch;

import java.util.*;
import java.io.*;

public class k번째수_1300_IMPORTANT {

    static int n, k, answer;

    public static void main (String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int lt = 1;
        int rt = k;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = 0;
            for (int i=1;i<=n;i++) {
                count += Math.min(n, mid / i);
            }

            if (count < k) {
                lt = mid + 1;
            }

            else {
                answer = mid;
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
