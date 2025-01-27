package inflearn.section3_2pointer;

import java.util.Scanner;

/**
 * n에 대해 2개 이상 연속된 자연수의 합을 묻는 것이므로, 자연수가 2개, 3개, ... 일 때 가능한지 확인해보자!
 * cnt > 2개, 3개, ... 체크
 * ex) 15를 만들 수 있는 연속된 자연수 2개 확인해보려 함
 *  - base : 1, 2
 *  - 15 - 1 - 2 = 12
 *  - 12 % 2 = 0이므로, 1과 2에 각각 6 (12/2의 결과) 를 더해 7과 8로 15를 만들 수 있음!
 *
 *  ex2) 15를 만들 수 있는 연속된 자연수 3개 확인해보려 함
 *   - base : 1, 2, 3
 *   - 15 - 1 - 2 - 3 = 9
 *   - 9 % 3 = 0이므로, 1, 2, 3에 각각 3 (9/3의 결과) 를 더해 4, 5, 6으로 15를 만들 수 있음!
 *
 *  ex3) 15를 만들 수 있는 연속된 자연수 4개 확인
 *   - base : 1, 2, 3, 4
 *   - 15 - 1 - 2 - 3 - 4 = 5
 *   - 5 % 4 = 1이므로, 연속된 자연수 4개로는 15를 만들 수 없음!
 *
 */
public class problem5_연속된자연수의합_math {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        int sum = 3;
        int cnt = 2;
        while (sum < n) {
            if ((n - sum) % cnt == 0) answer++;
            sum += ++cnt;
        }

        if (sum == n) answer++;
        return answer;
    }
}
