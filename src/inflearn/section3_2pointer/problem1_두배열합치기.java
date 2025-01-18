package inflearn.section3_2pointer;

import java.io.*;
import java.util.*;

/**
 같은 건 하나만 출력하고 넘어가서 틀림;;
 ex) 1 2 3 3 5 가 아니라 1 2 3 5 ...

 BufferedReader 과 Scanner 동시 사용해 Runtime Error 발생
 */
public class problem1_두배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        solution(arr1, arr2);
    }

    private static void solution(int[] arr1, int[] arr2) {
        int arr1Pt = 0;
        int arr2Pt = 0;

        while (arr1Pt < arr1.length && arr2Pt < arr2.length) {
            if (arr1[arr1Pt] < arr2[arr2Pt]) System.out.print(arr1[arr1Pt++] + " ");
            else if (arr2[arr2Pt] < arr1[arr1Pt]) System.out.print(arr2[arr2Pt++] + " ");
            else if (arr1[arr1Pt] == arr2[arr2Pt]) {
                System.out.print(arr1[arr1Pt++] + " ");
                System.out.print(arr2[arr2Pt++] + " ");
            }
        }

        if (arr1Pt == arr1.length) {
            for (int i = arr2Pt; i < arr2.length; i++) {
                System.out.print(arr2[i] + " ");
            }
        } else {
            for (int i = arr1Pt; i < arr1.length; i++) {
                System.out.print(arr1[i] + " ");
            }
        }
    }
}
