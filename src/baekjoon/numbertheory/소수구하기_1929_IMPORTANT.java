package baekjoon.numbertheory;

import java.util.*;
import java.io.*;

public class 소수구하기_1929_IMPORTANT {
    static int m, n;
    static boolean [] isPrime;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i<=Math.sqrt(n);i++) {

            if (!isPrime[i]) continue;

            for (int j = 2; i*j<=n;j++) {
                isPrime[i * j] = false;
            }
        }

        isPrime[2] = true;
        for (int num=m;num<=n;num++) {
            if (isPrime[num] == true) bw.write(String.valueOf(num) + "\n");
        }
        bw.flush();
    }
}
