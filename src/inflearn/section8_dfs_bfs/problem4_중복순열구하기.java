package inflearn.section8_dfs_bfs;

import java.util.*;

public class problem4_중복순열구하기 {
    static int n, m;
    static int [] counts;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        counts = new int[n + 1];

        solution(0);
    }

    private static void solution(int chosenCount) {
        if (chosenCount == m) {
            for(int i=1;i<=n;i++) {
                if (counts[i] > 0) {
                    for (int j = 0; j < counts[i]; j++) {
                        System.out.print(i + " ");
                    }
                }
            }

            System.out.println();
        }

        else {
          for(int i=1;i<=n;i++) {
              counts[i]++;
              solution(chosenCount+1);
              counts[i]--;
              solution(chosenCount);
          }
        }
    }
}
