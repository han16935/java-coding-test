package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class DSLR_9019_IMPORTANT {

    static int n;
    static boolean [] isVisited;

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isVisited = new boolean[10000];
        StringTokenizer st;
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            int firstNumber = Integer.parseInt(st.nextToken());
            int secondNumber = Integer.parseInt(st.nextToken());

            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(new Node(firstNumber, new StringBuilder("")));

            while(!queue.isEmpty()) {
                Node polledNode = queue.poll();
                if (polledNode.currentValue == secondNumber) {
                    System.out.println(polledNode.commandSet);
                    break;
                }

                if (isVisited[polledNode.currentValue]) continue;

                isVisited[polledNode.currentValue] = true;

                Node dNode = polledNode.operateD();
                if (!isVisited[dNode.currentValue]) {
                    queue.offer(dNode);
                }

                Node sNode = polledNode.operateS();
                if (!isVisited[sNode.currentValue]) {
                    queue.offer(sNode);
                }

                Node lNode = polledNode.operateL();
                if (!isVisited[lNode.currentValue]) {
                    queue.offer(lNode);
                }

                Node rNode = polledNode.operateR();
                if (!isVisited[rNode.currentValue]) {
                    queue.offer(rNode);
                }
            }

            Arrays.fill(isVisited, false);
        }
    }

    static class Node {

        int currentValue;
        StringBuilder commandSet;

        public Node(int currentValue, StringBuilder commandSet) {
            this.currentValue = currentValue;
            this.commandSet = commandSet;
        }

        public Node operateD() {
            int newValue = this.currentValue;
            StringBuilder newCommandSet = new StringBuilder(this.commandSet.toString());

            if (newValue * 2 > 9999) {
                newValue = newValue * 2 % 10000;
            }
            else newValue *= 2;

            newCommandSet.append('D');

            return new Node(newValue, newCommandSet);
        }

        public Node operateS() {
            int newValue = this.currentValue;
            StringBuilder newCommandSet = new StringBuilder(this.commandSet.toString());

            if (newValue == 0) {
                newValue = 9999;
            }
            else newValue -= 1;

            newCommandSet.append('S');

            return new Node(newValue, newCommandSet);
        }

        public Node operateL() {
            int newValue = this.currentValue;
            StringBuilder newCommandSet = new StringBuilder(this.commandSet.toString());

            int d1 = newValue / 1000;
            int d2 = (newValue / 100) % 10 ;
            int d3 = (newValue / 10) % 10;
            int d4 = newValue % 10;

            newValue = d2 * 1000 + d3 * 100 + d4 * 10 + d1;

            newCommandSet.append('L');
            return new Node(newValue, newCommandSet);
        }

        public Node operateR() {
            int newValue = this.currentValue;
            StringBuilder newCommandSet = new StringBuilder(this.commandSet.toString());

            int d1 = newValue / 1000;
            int d2 = (newValue / 100) % 10 ;
            int d3 = (newValue / 10) % 10;
            int d4 = newValue % 10;

            newValue = d4 * 1000 + d1 * 100 + d2 * 10 + d3;

            newCommandSet.append('R');
            return new Node(newValue, newCommandSet);
        }
    }
}
