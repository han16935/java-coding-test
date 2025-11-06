package baekjoon.numbertheory;

import java.util.*;
import java.io.*;

public class 칵테일_1033_IMPORTANT {
    static int n;
    static long [] answer;
    static boolean [] isVisited;
    static List<List<Node>> list = new ArrayList<>();

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        answer = new long[n];
        isVisited = new boolean[n];
        Arrays.fill(answer, 1);
        for (int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        long lcm = 1;
        for (int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            lcm *= (p * q / getGcd(p, q));

            list.get(a).add(new Node(b, p, q));
            list.get(b).add(new Node(a, q, p));
        }

        answer[0] = lcm;

        isVisited[0] = true;
        dfs(0);

        long globalGcd = answer[0];
        for (int i=1;i<n;i++) {
            globalGcd = getGcd (globalGcd, answer[i]);
        }

        for (int i=0;i<n;i++) {
            bw.write(answer[i] / globalGcd + " ");
        }
        bw.flush();
    }


    static class Node {

        int index;
        int p;
        int q;

        public Node (int index, int p, int q) {
            this.index = index;
            this.p = p;
            this.q = q;
        }
    }

    static long getGcd (long a, long b) {
        if (a % b == 0) return b;
        else return getGcd (b, a % b);
    }

    static void dfs (int currentIndex) {

        List<Node> nextNodeList = list.get(currentIndex);

        for (int i=0;i<nextNodeList.size();i++) {
            Node nextNode = nextNodeList.get(i);
            if (!isVisited[nextNode.index]) {
                isVisited[nextNode.index] = true;
                answer[nextNode.index] = answer[currentIndex] * nextNode.q / nextNode.p;
                dfs(nextNode.index);
            }
        }
    }
}
