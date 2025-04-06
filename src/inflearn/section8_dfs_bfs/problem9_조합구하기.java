package inflearn.section8_dfs_bfs;

import java.util.Scanner;

public class problem9_조합구하기 {

    static int n, m;
    static boolean [] answers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answers = new boolean[n + 1];
        solution(1, 0);
    }

    private static void solution(int currentNum, int count) {

        if (currentNum == n + 1 && count < m) return;

        if (count == m) {
            for(int i=1;i<=n;i++) {
                if (answers[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        else {
            answers[currentNum] = true;
            solution(currentNum+1, count+1);
            answers[currentNum] = false;
            solution(currentNum + 1, count);
        }
    }
}
