package baekjoon.sort;

import java.util.*;
import java.io.*;

public class 버블소트_1377_IMPORTANT {

    static int n;
    static int answer = Integer.MIN_VALUE;
    static List<Node> arr = new ArrayList<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            int value = Integer.parseInt(br.readLine());
            arr.add(new Node(value, i));
        }

        Collections.sort(arr, new NodeComparator());
        for (int sortedIndex = 0; sortedIndex < n; sortedIndex++) {
            answer = Math.max(answer, arr.get(sortedIndex).originalIndex - sortedIndex);
        }

        System.out.println(answer + 1);
    }

    static class Node {
        int value;
        int originalIndex;

        public Node (int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
           return n1.value - n2.value;
        }
    }
}
