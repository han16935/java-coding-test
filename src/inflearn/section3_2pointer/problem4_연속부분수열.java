package inflearn.section3_2pointer;

import java.io.*;
import java.util.*;

/**
 * 투 포인터, 슬라이딩 윈도우 > O(n^2)를 O(n)으로 하고 싶을 때
 *
 */
public class problem4_연속부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0;
        for(int i=0;i<n;i++) {
            int tmp = arr[i];
            for(int j=i+1;j<n;j++) {
                tmp += arr[j];
                if (tmp >= m) {
                    if (tmp == m) answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
