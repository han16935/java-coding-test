package baekjoon.numbertheory;

import java.util.*;
import java.io.*;

public class 최대공약수_1850_IMPORTANT {

    static long a, b;
    static long answer;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        answer = getGcd(a, b);

        for (long i=0;i<answer;i++) {
            bw.write(String.valueOf(1));
        }

        bw.flush();
    }

    static long getGcd(long a, long b) {
        long x = a;
        long y = b;

        while (x % y != 0) {
            long mod = x % y;
            x = y;
            y = mod;
        }

        return y;
    }
}
