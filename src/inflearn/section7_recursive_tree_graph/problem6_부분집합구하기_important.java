package inflearn.section7_recursive_tree_graph;

import java.util.*;

public class problem6_부분집합구하기_important {
    static int n;
    static boolean [] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new boolean[n + 1];
        solution(1, n+1);
    }

    private static void solution(int n, int limit) {
        if (n == limit) {
            StringBuilder sb = new StringBuilder();
            for (int i=1;i<n;i++) {
                if (arr[i]) sb.append(i);
            }
            System.out.println(sb);
        }
        else {
            arr[n] = true;
            solution(n+1, limit);
            arr[n] = false;
            solution(n+1, limit);
        }
    }
}
