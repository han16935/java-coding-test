package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 수들의합5_2018 {

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int lt = 1;
        int rt = 1;
        int answer = 1; // n 자신 포함
        long sum = 1;

        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        while (rt <= n/2 + 1) {

            if (sum == n) {
                sum -= lt;
                lt++;
                answer++;
            }

            if (sum < n) {
                rt++;
                sum += rt;
            }

            if (sum > n) {
                sum -= lt;
                lt++;
            }
        }

        System.out.println(answer);
    }
}
