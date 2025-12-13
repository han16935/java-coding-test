package baekjoon.bfs;

import java.util.*;
import java.io.*;

public class 트리의지름_1167_IMPORTANT {
    static int v;
    static int answer = Integer.MIN_VALUE;
    static List<List<Node>> arr = new ArrayList<>();
    static Deque<Node> queue = new ArrayDeque<>();
    static boolean [] isVisited;
    static int [] dis;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        isVisited = new boolean[v + 1];
        dis = new int[v + 1];
        for (int i=0;i<=v;i++) {
            arr.add(new ArrayList<>());
        }

        for (int j=0;j<v;j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;

                int dis = Integer.parseInt(st.nextToken());
                arr.get(start).add(new Node(end, dis));
            }
        }

        bfs(1);
        int max = 1;
        for (int node=1;node<=v;node++) {
            if (dis[node] > dis[max]) max = node;
        }
        Arrays.fill(dis, 0);
        Arrays.fill(isVisited, false);
        bfs(max);
        Arrays.sort(dis);
        System.out.println(dis[dis.length - 1]);
    }

    static void bfs (int start) {

        isVisited[start] = true;
        dis[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node polledNode = queue.poll();
            List<Node> polledNodeArr = arr.get(polledNode.end);
            for (int i=0;i<polledNodeArr.size();i++) {
                Node nextPos = polledNodeArr.get(i);
                if (!isVisited[nextPos.end]) {
                    isVisited[nextPos.end] = true;
                    dis[nextPos.end] = dis[polledNode.end] + nextPos.dis;
                    queue.offer(new Node(nextPos.end, nextPos.dis + polledNode.dis));
                }
            }
        }
    }

    static class Node {
        int end;
        int dis;

        public Node (int end, int dis) {
            this.end = end;
            this.dis = dis;
        }
    }


}
