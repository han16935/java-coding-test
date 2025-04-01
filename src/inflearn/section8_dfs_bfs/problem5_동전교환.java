package inflearn.section8_dfs_bfs;

import java.util.*;
import java.io.*;

public class problem5_동전교환 {

    static int n, m;
    static List<Integer> arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(Collections.reverseOrder());

        m = Integer.parseInt(br.readLine());
        solution(m, 0);
        System.out.println(answer);
    }

    private static void solution(int restMoney, int cnt) {
        if (restMoney < 0 || cnt > answer) return;
        if (restMoney == 0 && cnt < answer) {
            answer = cnt;
        }

        else {
            for(int i=0;i<n;i++) {
                solution(restMoney - arr.get(i), cnt+1);
            }
        }
    }
}
