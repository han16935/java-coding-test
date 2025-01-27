package inflearn.section4_hashMap_hashSet_treeSet;

import java.io.*;
import java.util.*;

public class problem3_매출액종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, k, arr);
    }

    private static void solution(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int lt=0;
        int rt=0;
        int cnt = 0;
        while(rt<n) {

            if (cnt < k) {
                map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
                rt++;
                cnt++;
            }

            else if (cnt == k) {
                System.out.print(map.size() + " ");

                if (map.get(arr[lt]) == 1) map.remove(arr[lt]);
                else map.put(arr[lt], map.get(arr[lt]) - 1);

                lt++;
                cnt--;
            }
        }

        System.out.println(map.size() + " ");
    }
}
