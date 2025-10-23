package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class 회의실배정_1931 {
    static int n, answer;
    static List<Node> list = new ArrayList<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }

        Collections.sort(list, new NodeComparator());

        int currentMeetEndtime = -1;
        for (Node n : list) {

            if (currentMeetEndtime == -1) {
                currentMeetEndtime = n.end;
                answer++;
            }

            else if (currentMeetEndtime <= n.start) {
                answer++;
                currentMeetEndtime = n.end;
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int start;
        int end;

        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node n1, Node n2) {
            if (n1.end == n2.end) return Math.abs(n2.start - n2.end) - Math.abs(n1.start - n1.end);
            else return n1.end - n2.end;
        }
    }
}
