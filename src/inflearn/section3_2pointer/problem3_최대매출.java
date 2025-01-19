package inflearn.section3_2pointer;

import java.io.*;
import java.util.*;

public class problem3_최대매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        int answer = 0;

        // 1. answer 초기화
        for(int i=0;i<k;i++) {
            answer += arr[i];
        }
        if (n == k) return answer;

        int tmp = answer;
        // 2. 부분합 구한 뒤 현재 answer와 비교
        for(int j=0;j<n-k;j++) {
            tmp = tmp - arr[j] + arr[j + k];
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}
