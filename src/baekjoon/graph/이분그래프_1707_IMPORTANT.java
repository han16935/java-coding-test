package baekjoon.graph;

import java.util.*;
import java.io.*;

public class 이분그래프_1707_IMPORTANT {

    static int n;
    static boolean hasCycle;
    static List<List<Integer>> arr;
    static int[] sets;
    static boolean [] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sets = new int[v + 1];
            isVisited = new boolean[v + 1];
            arr = new ArrayList<>();
            for (int j = 0; j <= v; j++) {
                arr.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                arr.get(start).add(end);
                arr.get(end).add(start);
            }

            hasCycle = false;

            for (int k = 1; k <= v; k++) {
                if (hasCycle) break;
                else {
                    sets[k] = 1;
                    solution(k, 1);
                    sets = new int[v + 1];
                }

            }
            System.out.println(hasCycle ? "NO" : "YES");
        }
    }

    static void solution(int currentPos, int currentSet) {
        if (hasCycle) return;

        isVisited[currentPos] = true;

        List<Integer> nextPosCandidates = arr.get(currentPos);
        int nextSet = 3 - currentSet; // 1 -> 2, 2 -> 1

        for (int nextPos : nextPosCandidates) {

            if (!isVisited[nextPos]) {
                sets[nextPos] = nextSet;
                solution(nextPos, nextSet);
            }

            else if (sets[nextPos] == sets[currentPos]) {
                hasCycle = true;
                break;
            }
        }
    }
}
