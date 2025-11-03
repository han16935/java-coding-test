package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 최단경로_1753 {
    static int v, e, start;
    static List<List<Node>> arr = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean [] isVisited;
    static int [] answer;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i=0;i<=v;i++) {
            arr.add(new ArrayList<>());
        }
        isVisited = new boolean[v + 1];
        answer = new int[v + 1];
        for (int i=1;i<=v;i++) {
            answer[i] = Integer.MAX_VALUE;
        }
        start = Integer.parseInt(br.readLine());
        answer[start] = 0;

        for (int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, weight));
        }

        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node currentPosNode = pq.poll();
            int currentPos = currentPosNode.end;
            int currentDis = currentPosNode.dis;

            if (isVisited[currentPos]) continue;
            isVisited[currentPos] = true;

            List<Node> nextPosCandidates = arr.get(currentPos);
            for (int i=0;i<nextPosCandidates.size();i++) {
                Node nextPosCandidate = nextPosCandidates.get(i);
                int nextPosCandidatePos = nextPosCandidate.end;
                int nextNodeDis = nextPosCandidate.dis + currentDis;

                if (!isVisited[nextPosCandidatePos] && nextNodeDis < answer[nextPosCandidatePos]) {
                    pq.offer(new Node(nextPosCandidatePos, nextNodeDis));
                    answer[nextPosCandidatePos] = nextNodeDis;
                }
            }
        }

        for (int i=1;i<=v;i++) {
            if (answer[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(String.valueOf(answer[i]) + "\n");
        }

        bw.flush();
    }

    static class Node implements Comparable<Node> {
        int end;
        int dis;

        public Node (int end, int dis) {
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node other) {
            return this.dis - other.dis;
        }
    }
}
