package baekjoon.tree;

import java.util.*;
import java.io.*;

public class 트리의부모찾기_11725 {
    static int n;
    static List<List<Integer>> arr = new ArrayList<>();
    static int [] answer;
    static boolean [] isVisited;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        answer = new int[n + 1];
        isVisited = new boolean[n + 1];
        for (int i=0;i<=n;i++) {
            arr.add(new ArrayList<>());
        }

        for (int j=1;j<=n-1;j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.get(start).add(end);
            arr.get(end).add(start);
        }

        isVisited[1] = true;
        solution(1, -1);

        for (int i=2;i<=n;i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
    }

    static void solution(int currentPos, int parent) {

        if (parent != -1) answer[currentPos] = parent;

        List<Integer> nextNodeList = arr.get(currentPos);
        int size = nextNodeList.size();

        for (int i=0;i<size;i++) {
            int nextNode = nextNodeList.get(i);
            if (!isVisited[nextNode]) {
                isVisited[nextNode] = true;
                solution(nextNode, currentPos);
            }
        }
    }
}
