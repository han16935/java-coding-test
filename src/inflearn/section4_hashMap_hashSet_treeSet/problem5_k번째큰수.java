package inflearn.section4_hashMap_hashSet_treeSet;

import java.io.*;
import java.util.*;

public class problem5_k번째큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                for(int kk=j+1;kk<n;kk++) {
                    set.add(arr[i] + arr[j] + arr[kk]);
                }
            }
        }
        if (set.size() < k) return -1;
        return (Integer) set.toArray()[set.size()-k];
    }
}
