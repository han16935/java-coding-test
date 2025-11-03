package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 최소스패닝트리_1197 {
    static int v, e;
    static long answer;
    static int [] set;
    static PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

    public static void main (String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        set = new int[v + 1];
        for (int i=1;i<=v;i++) {
            set[i] = i;
        }

        for (int j=0;j<e;j++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Node(start, end, weight));
        }

        while (!pq.isEmpty()) {
            Node polledNode = pq.poll();
            int start = polledNode.start;
            int end = polledNode.end;
            int weight = polledNode.weight;
            if (isNotSameSet(start, end)) {
                union(start, end);
                answer += weight;
            }
        }

        System.out.println(answer);
    }

    static int find (int setNum) {
        if (set[setNum] == setNum) return setNum;
        else return set[setNum] = find(set[setNum]);
    }

    static boolean isNotSameSet (int firstSetNum, int secondSetNum) {
        return find(firstSetNum) != find(secondSetNum);
    }

    static void union (int firstSetNum, int secondSetNum) {
        int firstSetParent = find(firstSetNum);
        int secondSetParent = find(secondSetNum);
        if (firstSetParent != secondSetParent) {
            set[firstSetParent] = secondSetParent;
        }
    }

    static class Node {
        int start;
        int end;
        int weight;

        public Node (int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.weight - n2.weight;
        }
    }
}
