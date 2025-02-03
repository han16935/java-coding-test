package inflearn.section6_sorting_searching;

import java.util.*;
import java.io.*;

public class problem8_이분검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(solution(m, arr, 1, n));
    }

    private static int solution(int m, int[] arr, int lt, int rt) {
        int mid = (lt + rt) / 2;
        if (arr[mid] == m) return mid;
        else if (arr[mid] < m) return solution(m, arr, mid+1, rt);
        else return solution(m, arr, lt, mid-1);
    }
}
