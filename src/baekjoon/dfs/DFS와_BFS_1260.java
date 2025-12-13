package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class DFS와_BFS_1260 {
    static int n, m, v;
    static int [] answer;
    static boolean [] isVisited;
    static List<List<Integer>> arr = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> stack = new ArrayDeque<>();
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        answer = new int[n];
        isVisited = new boolean[n + 1];

        for (int i=0;i<=n;i++) {
            arr.add(new ArrayList<>());
        }

        for (int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.get(start).add(end);
            arr.get(end).add(start);
        }

        for (int k=1;k<=n;k++) {
            Collections.sort(arr.get(k));
        }

        stack.push(v);
        dfs ();
        isVisited = new boolean[n+1];
        answer = new int[n];
        queue.offer(v);
        bfs ();
    }

    static void dfs () throws Exception {
        while (!stack.isEmpty()) {
            int currentPos = stack.pop();
            if (isVisited[currentPos]) continue;

            isVisited[currentPos] = true;
            bw.write(String.valueOf(currentPos) + " ");

            List<Integer> currentPosGraph = arr.get(currentPos);
            for (int i = currentPosGraph.size()-1; i>=0;i--) {
                if (!isVisited[currentPosGraph.get(i)]) {
                    stack.push(currentPosGraph.get(i));
                }
            }
        }
        bw.write("\n");
        bw.flush();
    }

    static void bfs () throws Exception {
        while (!queue.isEmpty()) {
            int currentPos = queue.poll();
            if (isVisited[currentPos]) continue;

            isVisited[currentPos] = true;
            bw.write(String.valueOf(currentPos) + " ");

            List<Integer> currentPosGraph = arr.get(currentPos);
            for (int i=0;i<currentPosGraph.size();i++) {
                if (!isVisited[currentPosGraph.get(i)]) {
                    queue.offer(currentPosGraph.get(i));
                }
            }
        }

        bw.write("\n");
        bw.flush();
    }
}
