package baekjoon.tree;

import java.util.*;
import java.io.*;

public class 트리순회_1991 {
    static int n;
    static List<List<Node>> arr = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            arr.add(new ArrayList<>());
        }

        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = toNum(st.nextToken()); // A > 0
            int left = toNum(st.nextToken()); // B > 1
            int right = toNum(st.nextToken()); // C > 2
            arr.get(root).add(new Node(root, left, right));
        }

        preOrder(arr.get(0).get(0));
        bw.write("\n");

        inOrder(arr.get(0).get(0));
        bw.write("\n");

        postOrder(arr.get(0).get(0));

        bw.flush();
    }

    static void preOrder(Node n) throws Exception {
        bw.write((char) (n.root + 65));
        if (n.left != -1) preOrder(arr.get(n.left).get(0));
        if (n.right != -1) preOrder(arr.get(n.right).get(0));
    }

    static void inOrder(Node n) throws Exception {
        if (n.left != -1) inOrder(arr.get(n.left).get(0));
        bw.write((char) (n.root + 65));
        if (n.right != -1) inOrder(arr.get(n.right).get(0));
    }

    static void postOrder(Node n) throws Exception {
        if (n.left != -1) postOrder(arr.get(n.left).get(0));
        if (n.right != -1) postOrder(arr.get(n.right).get(0));
        bw.write((char) (n.root + 65));
    }

    static class Node {
        int root;
        int left;
        int right;

        public Node (int root, int left, int right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    static int toNum (String token) {
        char result = token.toCharArray()[0];
        if (result == '.') return -1;
        else return result - 65;
    }
}
