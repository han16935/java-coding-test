package inflearn.section9_greedy;

import java.util.*;
import java.io.*;

public class problem8_원더랜드_PQ_IMPORTANT {

    static int v;
    static int e;
    static int answer;
    static boolean[] isVisited;
    static List<List<Edge>> list = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        isVisited = new boolean[v + 1];
        for (int i = 0; i <= v + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Edge e = new Edge(v2, weight);
            list.get(v1).add(e);
            list.get(v2).add(new Edge(v1, weight));
        }

        pq.offer(new Edge(1,0));

        while (!pq.isEmpty()) {
            Edge polledEdge = pq.poll();

            if (isVisited[polledEdge.v2]) continue; // (9, 8) 로 이미 8번에 대한 루트가 확보된 상태에서 (2, 8) 이 poll 될 경우 대비
            isVisited[polledEdge.v2] = true;
            answer += polledEdge.weight;

            List<Edge> edges = list.get(polledEdge.v2);
            for (Edge edge : edges) {
                if (!isVisited[edge.v2]) {
                    pq.offer(edge);
                }
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int v2;
        int weight;

        public Edge(int v2, int weight) {
            this.v2 = v2;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
}
