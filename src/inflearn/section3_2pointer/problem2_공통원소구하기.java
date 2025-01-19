package inflearn.section3_2pointer;

import java.io.*;
import java.util.*;

public class problem2_공통원소구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);

        solution(n, arr1, m, arr2);
    }

    private static void solution(int n, int[] arr1, int m, int[] arr2) {
        int arr1Pt = 0;
        int arr2Pt = 0;
        while(arr1Pt < n && arr2Pt < m) {
            if (arr1[arr1Pt] < arr2[arr2Pt]) arr1Pt++;
            else if (arr2[arr2Pt] < arr1[arr1Pt]) arr2Pt++;
            else {
                System.out.print(arr1[arr1Pt++] + " ");
                arr2Pt++;
            }
        }
    }
}
