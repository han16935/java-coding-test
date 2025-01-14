package inflearn.section3_array;

import java.io.*;
import java.util.*;

public class problem9_최대합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        int j = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
            j = 0;
        }
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int answer = 0;
        int subMax = 0;
        // 1. 가로 구하기
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                subMax += arr[i][j];
            }
            answer = Math.max(answer, subMax);
            subMax = 0;
        }

        // 2. 세로 구하기
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                subMax += arr[j][i];
            }
            answer = Math.max(answer, subMax);
            subMax = 0;
        }

        // 3. 대각선 구하기
        for(int i=0;i<n;i++) {
            subMax += arr[i][i];
        }
        answer = Math.max(answer, subMax);
        subMax = 0;

        for(int i=0;i<n;i++) {
            subMax += arr[i][n - i - 1];
        }
        answer = Math.max(answer, subMax);

        return answer;
    }
}
