package inflearn.section2_array;

import java.util.Scanner;

/**
 * 에라토스테네스의 체
 *    - n이 들어오면 그 크기 + 1만큼의 배열 생성, 0으로 초기화
 *    - 2부터 시작, 그 후 2의 배수는 전부 1 표기
 *    - 그 다음부터 1이라면 패스, 0이라면 그 수의 배수 전부 1 표기
 *
 */
public class problem5_에라토스테네스 {

    private static int solution(int n) {
        int [] arr = new int[n+1];
        int answer = 0;

        for(int i=2;i<=n;i++) {
            if (arr[i] == 0) {
                for(int j=1;i*j<=n;j++) {
                    arr[i*j] = 1;
                }
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
