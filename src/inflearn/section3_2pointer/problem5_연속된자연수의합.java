package inflearn.section3_2pointer;

import java.util.*;

/**
 * 앞서 풀었던 연속부분수열과 비슷하게 풀었음, 단 이 때 rt의 범위는 n/2 + 1로! (15 기준 8까지) 15 예시로 8 + 9, 어차피 15 넘어감
 */
public class problem5_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        int sum = 1;
        int lt = 1;
        int rt = 1;

        while(rt <= n/2 + 1) {
            if (sum < n) {
                rt++;
                sum += rt;
            }

            else if (sum > n) {
                sum -= lt;
                lt++;
            }

            else {
                answer++;
                sum -= lt;
                lt++;
            }
        }

        while (sum > n) {
            sum -= lt;
            lt++;
        }

        if (sum == n) answer++;
        return answer;
    }
}
