package baekjoon.numbertheory;

import java.util.*;
import java.io.*;

public class 거의소수_1456_IMPORTANT {

    static long a, b, answer;
    static boolean [] isPrime;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        int sqrtValue = (int) Math.sqrt(b);
        isPrime = new boolean[sqrtValue + 1];
        Arrays.fill(isPrime, true);

        for (int i=2;i<=sqrtValue;i++) {
            if (!isPrime[i]) continue;
            for (int j=2;i*j<=sqrtValue;j++) {
                isPrime[i * j] = false;
            }
        }

        for (int num = 2; num <= sqrtValue; num++) {
            if (isPrime[num]) {
                int n = 2;
                while (num <= b /  Math.pow(num, n - 1)) {
                    answer++;
                    n++;
                }
            }
        }

        for (int num = 2; num <= (int) Math.sqrt(a); num++) {
            if (isPrime[num]) {
                int n = 2;
                while (num < a /  Math.pow(num, n - 1)) {
                    answer--;
                    n++;
                }
            }
        }
        System.out.println(answer);
    }
}
