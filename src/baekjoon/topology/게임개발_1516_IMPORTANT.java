package baekjoon.topology;

import java.util.*;
import java.io.*;

public class 게임개발_1516_IMPORTANT {
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] needTimes;
    static int[] inDegree;
    static int[] answer;
    static Deque<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        needTimes = new int[n + 1];
        inDegree = new int[n + 1];
        answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            needTimes[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int beforeBuilt = Integer.parseInt(st.nextToken());
                if (beforeBuilt == -1) break;
                graph.get(beforeBuilt).add(i);
                inDegree[i]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) queue.offer(new Node(i, needTimes[i]));
        }

        while (!queue.isEmpty()) {
            Node polledNode = queue.poll();
            int currentNum = polledNode.currentNum;
            int currentTime = polledNode.currentTime;
            answer[currentNum] = Math.max(answer[currentNum], currentTime);

            List<Integer> nextCandidateList = graph.get(polledNode.currentNum);
            for (int nextCandidate : nextCandidateList) {
                inDegree[nextCandidate]--;
                answer[nextCandidate] = Math.max(answer[nextCandidate], answer[currentNum] + needTimes[nextCandidate]);
                if (inDegree[nextCandidate] == 0) {
                    queue.offer(new Node(nextCandidate, answer[currentNum] + needTimes[nextCandidate]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
    }

    static class Node {

        int currentNum;
        int currentTime;

        public Node(int currentNum, int currentTime) {
            this.currentNum = currentNum;
            this.currentTime = currentTime;
        }
    }
}
