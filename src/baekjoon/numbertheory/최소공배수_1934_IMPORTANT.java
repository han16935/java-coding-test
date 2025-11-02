package baekjoon.numbertheory;

import java.util.*;
import java.io.*;

public class 최소공배수_1934_IMPORTANT {
    static int n;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = getGcd(a, b);

            bw.write(String.valueOf(a * b / gcd) + "\n");
        }

        bw.flush();
    }

    static int getGcd(int a, int b) {
        int x = a;
        int y = b;

        while (x % y != 0) {
            int result = x % y;
            x = y;
            y = result;
        }

        return y;
    }
}
