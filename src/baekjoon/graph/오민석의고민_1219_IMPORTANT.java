package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 오민석의고민_1219_IMPORTANT {
    static int n, m, s, e;
    static boolean hasPositiveCycle;
    static boolean belongToPositiveCycle;
    static List<List<Node>> arr = new ArrayList<>();
    static Deque<Node> queue = new ArrayDeque<>();
    static Set<Integer> positiveCycleSet = new HashSet<>();
    static boolean [] isVisited;
    static int [] maxMoney;
    static int [] money;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n];
        money = new int[n];
        maxMoney = new int[n];
        for (int i=0;i<n;i++) {
            arr.add(new ArrayList<>());
            maxMoney[i] = Integer.MIN_VALUE;
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr.get(start).add(new Node(end, weight * -1));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<arr.get(i).size();j++) {
                int end = arr.get(i).get(j).end;
                arr.get(i).get(j).weight += money[end];
            }
        }

        maxMoney[s] = money[s];

        // n-1번 반복
        for (int count=0;count<n-1;count++) {
            for (int i=0;i<n;i++) {
                if (maxMoney[i] != Integer.MIN_VALUE) {
                    List<Node> nextCandidateList = arr.get(i);
                    for (int j=0;j<nextCandidateList.size();j++) {
                        Node nextCandidate = nextCandidateList.get(j);
                        if (maxMoney[nextCandidate.end] < maxMoney[i] + nextCandidate.weight) {
                            queue.offer(new Node(nextCandidate.end, maxMoney[i] + nextCandidate.weight));
                        }
                    }
                }
            }

            while (!queue.isEmpty()) {
                Node polledNode = queue.poll();
                maxMoney[polledNode.end] = polledNode.weight;
            }
        }

        for (int i=0;i<n;i++) {
            if (maxMoney[i] != Integer.MIN_VALUE) {
                List<Node> nextCandidateList = arr.get(i);
                for (int j=0;j<nextCandidateList.size();j++) {
                    Node nextCandidate = nextCandidateList.get(j);
                    if (maxMoney[nextCandidate.end] < maxMoney[i] + nextCandidate.weight) {
                        maxMoney[nextCandidate.end] = maxMoney[i] + nextCandidate.weight;
                        hasPositiveCycle = true;
                        positiveCycleSet.add(nextCandidate.end);
                    }
                }
            }
        }

        if (hasPositiveCycle) checkBelongToPositiveCycle();

        if (maxMoney[e] == Integer.MIN_VALUE) System.out.println("gg");
        else if (hasPositiveCycle && belongToPositiveCycle) System.out.println("Gee");
        else System.out.println(maxMoney[e]);
    }

    static void checkBelongToPositiveCycle() {
        for (int positiveCycleComponent : positiveCycleSet) {
            if (belongToPositiveCycle) return;

            boolean [] isVisitedToCheck = new boolean[n];
            Deque<Integer> queueToCheck = new ArrayDeque<>();
            queueToCheck.offer(positiveCycleComponent);
            isVisitedToCheck[positiveCycleComponent] = true;

            while (!queueToCheck.isEmpty()) {
                int currentPos = queueToCheck.poll();
                List<Node> nextCandidateList = arr.get(currentPos);
                for (Node nextCandidate : nextCandidateList) {

                    if (nextCandidate.end == e) {
                        belongToPositiveCycle = true;
                        break;
                    }

                    if (!isVisitedToCheck[nextCandidate.end]) {
                        queueToCheck.offer(nextCandidate.end);
                        isVisitedToCheck[nextCandidate.end] = true;
                    }
                }
            }
        }
    }

    static class Node {

        int end;
        int weight;

        public Node (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
