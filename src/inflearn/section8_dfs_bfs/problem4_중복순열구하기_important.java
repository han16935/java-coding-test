package inflearn.section8_dfs_bfs;

import java.util.*;

public class problem4_중복순열구하기_important {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        solution(0);
    }

    private static void solution(int chosenCount) {
        if (chosenCount == m) {
            for(int i=0;i<m;i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        else {
            for(int i=1;i<=n;i++) {
                arr[chosenCount] = i;
                solution(chosenCount+1);
            }
        }
    }
}

