package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 최소비용구하기_1916 {
    static int n, m, s, e;
    static long [] dis;
    static List<List<Node>> arr = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean [] isVisited;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n + 1];
        dis = new long[n + 1];
        for (int i=0;i<=n;i++) {
            dis[i] = Integer.MAX_VALUE;
            arr.add(new ArrayList<>());
        }

        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        pq.offer(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node polledNode = pq.poll();
            int currentPos = polledNode.end;
            int currentWeight = polledNode.weight;

            if (isVisited[currentPos]) continue;

            isVisited[currentPos] = true;
            dis[currentPos] = currentWeight;
            if (currentPos == e) break;

            List<Node> nextPosCandidateList = arr.get(currentPos);
            int size = nextPosCandidateList.size();
            for (int i=0;i<size;i++) {
                Node nextPosCandidate = nextPosCandidateList.get(i);
                if (!isVisited[nextPosCandidate.end] &&
                        currentWeight + nextPosCandidate.weight < dis[nextPosCandidate.end]) {
                    pq.offer(new Node(nextPosCandidate.end, nextPosCandidate.weight + currentWeight));
                }
            }
        }

        System.out.println(dis[e]);
    }

    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }
}
