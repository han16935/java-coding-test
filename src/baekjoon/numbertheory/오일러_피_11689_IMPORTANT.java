package baekjoon.numbertheory;

import java.util.*;
import java.io.*;

public class 오일러_피_11689_IMPORTANT {

    static long n, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        answer = n;

        for (int p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                answer = answer - answer / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            answer = answer - answer / n;
        }

        System.out.println(answer);
    }
}
