package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class 연결_요소의_개수_11724 {
    static int n, m;
    static long answer;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] isVisited;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }

        isVisited = new boolean[n+1];
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int start=1;start<=n;start++) {
            if (!isVisited[start]) {
                solution(start);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void solution (int start) {

        isVisited[start] = true;
        for (int nodeIndex=0;nodeIndex<graph.get(start).size();nodeIndex++){
            int destination = graph.get(start).get(nodeIndex);
            if (!isVisited[destination]) {
                solution(destination);
            }
        }
    }
}
