package inflearn.section3_2pointer;

import java.io.*;
import java.util.*;

/**
 * lt, rt가 초기 0부터 시작, rt가 전진하면서 arr[rt] 가 1이면 lt~rt 사이 거리 비교해 answer에 넣기
 *                                       arr[rt] 가 0이면 cnt 증가 (cnt는 전진하면서 만난 0 개수),
 *                                          - 만약 cnt가 k를 넘어가면 lt가 전진하면서 arr[lt] 가 0이면 cnt-- 하도록!
 *
 */
public class problem6_최대길이연속부분수열_x {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int [n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }


    private static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int lt = 0;
        int rt = 0;
        int cnt = 0;

        while(rt < arr.length) {
            if (arr[rt] == 1) {
                answer = Math.max(answer, rt - lt + 1);
                rt++;
            }

            else if (arr[rt] == 0) {
                while (cnt >= k) {
                   if (arr[lt] == 0) cnt--;
                   lt++;
                }
                answer = Math.max(answer, rt - lt + 1);
                rt++;
                cnt++;
            }
        }

        return answer;
    }
}
