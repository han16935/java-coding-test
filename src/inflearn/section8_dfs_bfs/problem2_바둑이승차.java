package inflearn.section8_dfs_bfs;

import java.util.*;
import java.io.*;

public class problem2_바둑이승차 {

    static int c, n;
    static int answer = Integer.MIN_VALUE;
    static int [] baduks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        baduks = new int [n];
        for(int i=0;i<n;i++) {
            baduks[i] = Integer.parseInt(br.readLine());
        }

        solution(-1, 0);
        System.out.println(answer);
    }

    private static void solution(int index, int tmpWeight) {
        if (tmpWeight > c) {
            return;
        }

        else {
            if (tmpWeight > answer) answer = tmpWeight;
            if (index + 1 == n) return;
            solution(index+1, tmpWeight + baduks[index+1]);
            solution(index+1, tmpWeight);
        }
    }
}
