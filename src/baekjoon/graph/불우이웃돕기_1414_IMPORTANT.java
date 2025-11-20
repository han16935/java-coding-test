package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 불우이웃돕기_1414_IMPORTANT {
    static int n, minimumLength, sum;
    static int [][] dis;
    static int [] set;
    static PriorityQueue<Line> pq = new PriorityQueue<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dis = new int[n][n];
        set = new int[n];
        for (int i=0;i<n;i++) {
            set[i] = i;
        }

        for (int i=0;i<n;i++) {
            String s = br.readLine();
            for (int j=0;j<n;j++) {
                char numChar = s.charAt(j);
                if (Character.isUpperCase(numChar)) dis[i][j] = (int) numChar-38;
                else if (Character.isLowerCase(numChar)) dis[i][j] = (int) numChar-96;
                else dis[i][j] = numChar - '0';

                sum += dis[i][j];
                if (dis[i][j] != 0) pq.offer(new Line(i, j, dis[i][j]));
            }
        }

        while (!pq.isEmpty()) {
            Line polledLine = pq.poll();
            if (polledLine.start == polledLine.end) continue;

            if (find(polledLine.start) != find(polledLine.end)) {
                union(polledLine.start, polledLine.end);
                minimumLength += polledLine.length;
            }
        }

        int root = find(0);
        for (int i=1;i<n;i++) {
            if (root != find(i)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sum - minimumLength);
    }

    static int find (int num) {
        if (num == set[num]) return num;
        else return set[num] = find(set[num]);
    }

    static void union (int first, int second) {
        int firstSetParent = find(first);
        int secondSetParent = find(second);
        if (firstSetParent != secondSetParent) set[secondSetParent] = firstSetParent;
    }
    static class Line implements Comparable<Line>{
        int start;
        int end;
        int length;

        public Line (int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo (Line other) {
            return this.length - other.length;
        }
    }
}
