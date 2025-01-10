package inflearn.section3_array;

import java.io.*;
import java.util.*;

public class problem4_피보나치수열 {

    private static void solution(int n) {
        int [] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        System.out.print(answer[0] + " ");
        System.out.print(answer[1] + " ");

        for(int i=2;i<n;i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
            System.out.println(answer[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        solution(n);
    }
}
