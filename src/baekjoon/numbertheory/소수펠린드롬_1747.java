package baekjoon.numbertheory;

import java.util.*;
import java.io.*;

public class 소수펠린드롬_1747 {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int arrSize = 10000002;
    static boolean [] isPrime;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        isPrime = new boolean[arrSize];
        Arrays.fill(isPrime, true);
        int sqrt = (int) Math.sqrt(arrSize);
        for (int num = 2; num <= sqrt; num ++) {
            if (!isPrime[num]) continue;
            for (int j = 2; num * j < arrSize; j++) {
                isPrime[num * j] = false;
            }
        }

        isPrime[1] = false;
        int tmp = n;
        while (true) {

            if (isPrime[tmp] && isPalindrome(tmp)) {
                answer = tmp;
                break;
            }

            else tmp++;
        }

        System.out.println(answer);
    }

    static boolean isPalindrome(int num) {

        String numChar = String.valueOf(num);


        int lt = 0;
        int rt = numChar.length() - 1;
        while (lt < rt) {
            if (numChar.charAt(lt) == numChar.charAt(rt)) {
                lt++;
                rt--;
            }

            else return false;
        }

        return true;
    }
}
