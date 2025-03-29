package inflearn.section7_recursive_tree_graph;

import java.util.Scanner;

public class problem4_피보나치수열 {

    static int [] arr;

    static int solution(int n) {
       if (n == 1 || n == 2) return arr[n] = 1;
       else {
           if (arr[n] > 0) return arr[n];
           else return arr[n] = solution(n - 1) + solution(n - 2);
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        solution(n);
        for(int i=1;i<=n;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
