package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class 신기한소수_2023 {
    static int n;
    static List<Integer> answer = new ArrayList<>();
    static int [] firstDigit = {2, 3, 5, 7};
    static int [] otherDigit = {1, 3, 5, 7, 9};

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for (int i=0;i<firstDigit.length;i++) {
            solution(firstDigit[i], 1);
        }

        Collections.sort(answer);
        for (int j=0;j<answer.size();j++) {
            bw.write(String.valueOf(answer.get(j)) + "\n");
        }
        bw.flush();
    }

    static void solution (int value, int digitSize) {
        if (digitSize == n) {
            answer.add(value);
        }

        else {
            for (int k=0;k<otherDigit.length;k++) {
                int nextValue = value * 10 + otherDigit[k];
                if (isPrime(nextValue)) solution(nextValue, digitSize+1);
            }
        }
    }

    static boolean isPrime(int num) {
        if (num == 1 || num == 2) return true;

        for (int i=2;i<=Math.sqrt(num);i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
