package inflearn.section2_array;

import java.io.*;
import java.util.*;

public class problem8_등수구하기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int i = 0;
        while(st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        solution(n, arr);
    }

    private static void solution(int n, int[] arr) {
        int [] answer = new int[n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (arr[j] > arr[i]) answer[i]++;
            }
        }
        for(int element : answer) {
            System.out.print(element+1+" ");
        }
    }

}
