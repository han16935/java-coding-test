package inflearn.section3_2pointer;

import java.io.*;
import java.util.*;

/**
 * 투 포인터, 슬라이딩 윈도우 > O(n^2)를 O(n)으로 하고 싶을 때
 * lt, rt를 기준으로 sum이 m보다 작으면 rt++ 하고 arr[rt] 더함
 * m보다 크면 sum -= arr[lt] 하고 lt++함
 * m과 같으면 answer++하고 lt 올림
 *
 * 이렇게 rt가 배열 끝까지 갈 때까지 하지만, 만약 이 상황에서 sum이 m보다 클 경우, lt 쪽 계속 빼면
 * sum == m인 경우 잇을 수도 있기 때문에 확인해봐야
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
        int lt = 0;
        int rt = 0;
        int sum = arr[0];
        while(rt < arr.length-1) {
            if (sum < m) {
                rt++;
                sum += arr[rt];
            }

            else if (sum > m) {
                sum -= arr[lt];
                lt++;
            }

            else {
                answer++;
                sum -= arr[lt];
                lt++;
            }
        }

        while (sum > m) {
           lt++;
           sum -= arr[lt];
        }

        if (sum == m) answer++;

        return answer;
    }
}
