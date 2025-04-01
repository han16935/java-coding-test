package inflearn.section8_dfs_bfs;

import java.util.*;

public class problem7_조합경우수 {

    static int n, r;
    static int [][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();
        arr = new int[n+1][r+1];

        System.out.println(solution(n, r));
    }

    private static int solution(int n, int r) {
        if (n == r) return 1;
        if (r == 1) return n;

        else {
            if (arr[n][r] != 0) return arr[n][r];
            else return arr[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
        }
    }
}
