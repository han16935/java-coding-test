package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 특정거리의도시찾기_18352 {
    static int n, m, k, x; // 도시/도로 개수, 최단 거리, 출발 도시, 도로 거리 전부 1
    static List<List<Integer>> arr = new ArrayList<>();
    static Deque<Node> queue = new ArrayDeque<>();
    static boolean [] isVisited;
    static int [] disArr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n + 1];
        disArr =  new int[n + 1];

        for (int i=0;i<=n;i++) {
            arr.add(new ArrayList<>());
        }

        for (int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.get(start).add(end);
        }

        disArr[x] = 0;
        isVisited[x] = true;
        queue.offer(new Node(x, 0));

        while (!queue.isEmpty()) {

            Node polledNode = queue.poll();
            int currentCity = polledNode.city;
            List<Integer> nextDestCities = arr.get(currentCity);

            for (int i = 0; i < nextDestCities.size(); i++) {
                int nextCandidateCity = nextDestCities.get(i);
                if (!isVisited[nextCandidateCity] && disArr[nextCandidateCity] == 0) {
                    int nextDis = polledNode.dis + 1;
                    isVisited[nextCandidateCity] = true;
                    disArr[nextCandidateCity] = nextDis;
                    queue.offer(new Node(nextCandidateCity, nextDis));
                }
            }
        }

        for (int i=1;i<=n;i++) {
            if (disArr[i] == k) {
                answer.append(i + "\n");
            }
        }

        if (answer.length() == 0) System.out.println(-1);
        else System.out.println(answer);
    }

    static class Node {
        int city;
        int dis;

        public Node (int city, int dis) {
            this.city = city;
            this.dis = dis;
        }
    }
}
