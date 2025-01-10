package inflearn.section3_array;

import java.io.*;
import java.util.*;

public class problem6_뒤집은소수 {

    private static void solution(int n, int[] arr) {
        for(int i=0;i<n;i++) {
            if (isPrime(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        for(int i=2;i<num;i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int i = 0;
        while(st.hasMoreTokens()) {
            StringBuilder num = new StringBuilder(st.nextToken()).reverse();
            arr[i++] = Integer.parseInt(num.toString());
        }
        solution(n, arr);
    }
}
