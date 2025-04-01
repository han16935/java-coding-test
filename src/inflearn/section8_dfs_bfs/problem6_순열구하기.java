package inflearn.section8_dfs_bfs;

import java.util.*;
import java.io.*;

public class problem6_순열구하기 {

    static int n, m;
    static int [] nums;
    static int [] answers;
    static boolean [] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()) {
            nums[i++] = Integer.parseInt(st.nextToken());
        }

        answers = new int[m];
        isVisited = new boolean[n];

        solution(0);
    }

    private static void solution(int D) {
        if (D == m) {
            for (int i=0;i<m;i++) {
                System.out.print(answers[i] + " ");
            }
            System.out.println();
        }

        else {
            for(int i=0;i<n;i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    answers[D] = nums[i];
                    solution(D+1);
                    isVisited[i] = false;
                }
            }
        }
    }
}
