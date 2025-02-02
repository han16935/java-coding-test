package inflearn.section6_sorting_searching;

import java.util.*;
import java.io.*;

public class problem6_장난꾸러기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] heightArr = new int[n+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<=n;i++) {
            int height = Integer.parseInt(st.nextToken());
            heightArr[i] = height;
            pq.add(height);
        }

        int chulSooNum = -1, pairNum = -1;
        for(int j=1;j<=n;j++) {
            if (heightArr[j] != pq.poll()) {
                if (chulSooNum == -1) chulSooNum = j;
                else pairNum = j;

                if (chulSooNum != -1 && pairNum != -1) break;
            }
        }

        System.out.println(chulSooNum + " " + pairNum);
    }
}
