package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 타임머신_11657 {
    static int n, m;
    static boolean isNegativeCycle;
    static List<Node> edges = new ArrayList<>();
    static Deque<DisChangeComponent> queue = new ArrayDeque<>();
    static int [] disArr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        disArr = new int[n + 1];
        Arrays.fill(disArr, Integer.MAX_VALUE);
        disArr[1] = 0;

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            edges.add(new Node(start, end, dis));
        }

        for (int count=0;count<n-1;count++) {
            boolean isChanged = false;

            for (Node edge : edges) {

                int start = edge.start;
                int end = edge.end;
                int dis = edge.dis;

                if (disArr[start] != Integer.MAX_VALUE) {
                    if (disArr[start] + dis < disArr[end]) {
                        queue.offer(new DisChangeComponent(end, disArr[start] + dis));
                        isChanged = true;
                    }
                }
            }

            if (!isChanged) break;
            while (!queue.isEmpty()) {
                DisChangeComponent component = queue.poll();
                disArr[component.end] = component.dis;
            }
        }

        // Negative Cycle Check
        for (Node edge : edges) {

            if (isNegativeCycle) break;

            int start = edge.start;
            int end = edge.end;
            int dis = edge.dis;

            if (disArr[start] != Integer.MAX_VALUE) {
                if (disArr[start] + dis < disArr[end]) {
                    isNegativeCycle = true;
                    break;
                }
            }
        }

        if (isNegativeCycle) bw.write("-1");
        else {
            for (int node = 2; node <=n; node++) {
                if (disArr[node] == Integer.MAX_VALUE) bw.write("-1\n");
                else bw.write(disArr[node] + "\n");
            }
        }

        bw.flush();
    }

    static class Node {

        int start;
        int end;
        int dis;

        public Node (int start, int end, int dis) {
            this.start = start;
            this.end = end;
            this.dis = dis;
        }
    }

    static class DisChangeComponent {

        int end;
        int dis;

        public DisChangeComponent(int end, int dis) {
            this.end = end;
            this.dis = dis;
        }
    }
}
