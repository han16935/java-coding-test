package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class ABCDE_13023 {
    static int n, m;
    static boolean answer;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean [] isVisited;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n];
        for (int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }

        for (int j=0;j<m;j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }

        for (int a=0;a<n;a++) {
            solution(a, 1);

        }

        System.out.println(answer ? 1 : 0);
    }

    static void solution(int currentFriend, int count) {
        if (count == 5) {
            answer = true;
        }

        if (answer) return;

        isVisited[currentFriend] = true;
        for (int currentFriendIdx=0;currentFriendIdx<list.get(currentFriend).size();currentFriendIdx++) {
            int nextFriendCandidate = list.get(currentFriend).get(currentFriendIdx);
            if (!isVisited[nextFriendCandidate]) solution(nextFriendCandidate, count + 1);
        }
        isVisited[currentFriend] = false;
    }
}
