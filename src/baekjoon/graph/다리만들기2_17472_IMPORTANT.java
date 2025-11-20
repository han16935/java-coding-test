package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 다리만들기2_17472_IMPORTANT {
    static int n, m;
    static int islandCount = 0;
    static long answer;
    static int [][] map;
    static boolean [][] isVisited;
    static int [] set;
    static int [] dn = {-1, 0, 1, 0}; // 12, 3, 6, 9
    static int [] dm = {0, 1, 0, -1}; // 12, 3, 6, 9
    static PriorityQueue<Bridge> pq = new PriorityQueue<>();

    public static void main (String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {

                if (map[i][j] == 1 && !isVisited[i][j]) {
                    Deque<Node> queue = new ArrayDeque<>();
                    queue.offer(new Node(i, j));
                    isVisited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node polledNode = queue.poll();
                        map[polledNode.n][polledNode.m] = islandCount + 1;

                        for (int direction=0;direction<4;direction++) {
                            int nextN = polledNode.n + dn[direction];
                            int nextM = polledNode.m + dm[direction];
                            if (nextN < 0 || nextN >= n || nextM < 0 || nextM >= m) continue;
                            if (!isVisited[nextN][nextM] && map[nextN][nextM] == 1) {
                                queue.offer(new Node(nextN, nextM));
                                isVisited[nextN][nextM] = true;
                            }
                        }
                    }
                    islandCount++;
                }
            }
        }

        set = new int[islandCount + 1];
        for (int i=1;i<=islandCount;i++) {
            set[i] = i;
        }

        // Bridge 후보 pq 넣기
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (map[i][j] >= 1) {
                    int startIsland = map[i][j];
                    for (int direction=0;direction<4;direction++) {
                        int endIsland;
                        int dis = 0;
                        int nextN = i + dn[direction];
                        int nextM = j + dm[direction];

                        while (0<=nextN && nextN<n && 0<=nextM && nextM < m && map[nextN][nextM] == 0) {
                            nextN += dn[direction];
                            nextM += dm[direction];
                            dis++;
                        }

                        if (dis >= 2 && 0<=nextN && nextN<n && 0<=nextM && nextM < m && map[nextN][nextM] != 0) {
                            endIsland = map[nextN][nextM];
                            pq.offer(new Bridge(startIsland, endIsland, dis));
                        }
                    }
                }
            }
        }

        if (pq.isEmpty()) {
            System.out.println(-1);
            return;
        }

        // pq 꺼내면서 계산
        while (!pq.isEmpty()) {
            Bridge polledBridge = pq.poll();
            int firstIsland = polledBridge.firstIsland;
            int secondIsland = polledBridge.secondIsland;
            if (find(firstIsland) != find(secondIsland)) {
                union(firstIsland, secondIsland);
                answer += polledBridge.dis;
            }
        }

        // 모든 섬이 연결되었는지 확인
        int root = find(1);
        for (int i=2;i<=islandCount;i++) {
            if (find(i) != root) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int n;
        int m;

        public Node (int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static class Bridge implements Comparable<Bridge> {
        int firstIsland;
        int secondIsland;
        int dis;

        public Bridge (int firstIsland, int secondIsland, int dis) {
            this.firstIsland = firstIsland;
            this.secondIsland = secondIsland;
            this.dis = dis;
        }

        @Override
        public int compareTo(Bridge other) {
            return this.dis - other.dis;
        }
    }

    static int find (int num) {
        if (num == set[num]) return num;
        else return set[num] = find(set[num]);
    }

    static void union (int firstSet, int secondSet) {
        int firstSetParent = find(firstSet);
        int secondSetParent = find(secondSet);
        if (firstSetParent != secondSetParent) set[secondSetParent] = firstSetParent;
    }
}
