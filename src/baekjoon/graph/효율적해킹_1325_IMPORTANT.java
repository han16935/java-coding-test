package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 효율적해킹_1325_IMPORTANT {
    static int n, m;
    static int maxAvailableHackCount;
    static List<List<Integer>> arr = new ArrayList<>();
    static int [] answer;
    static boolean [] isVisited;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i=0;i<=n;i++) {
            arr.add(new ArrayList<>());
        }
        answer = new int[n + 1];
        isVisited = new boolean[n + 1];

        for (int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr.get(start).add(end);
        }

        for (int start = 1; start <= n; start++) {
            isVisited[start] = true;
            dfs(start);
            Arrays.fill(isVisited, false);
        }

        for (int computer = 1; computer <= n; computer++) {
            maxAvailableHackCount = Math.max(answer[computer], maxAvailableHackCount);
        }

        for (int computer = 1; computer <= n; computer++) {
            if (answer[computer] == maxAvailableHackCount) {
                bw.write(computer + " ");
            }
        }
        bw.flush();
    }

    static void dfs (int current) {

        List<Integer> nextPosList = arr.get(current);
        int size = nextPosList.size();

        for (int i=0;i<size;i++) {
            int nextPos = nextPosList.get(i);
            if (!isVisited[nextPos]) {
                answer[nextPos]++;
                isVisited[nextPos] = true;
                dfs (nextPos);
            }
        }
    }
}
