package inflearn.section3_array;

import java.io.*;
import java.util.*;

public class problem2_보이는학생 {

    private static int solution(int n, int [] arr) {
        int maxHeight = arr[0];
        int answer = 1;

        for(int i=1;i<n;i++) {
           if (arr[i] > maxHeight) {
               maxHeight = arr[i];
               answer++;
           }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] students = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()) {
            students[i++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, students));
    }
}
