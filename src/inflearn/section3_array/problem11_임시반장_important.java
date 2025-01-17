package inflearn.section3_array;

import java.io.*;
import java.util.*;


public class problem11_임시반장_important {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][6];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, arr));
    }

    /**
     * i > 비교할 첫 번째 학생
     * j > 비교할 두 번째 학생
     * k > k학년일 때 i번째 학생과 j번째 학생이 같은 반이엇는지 확인
     *      - break를 해 주는 이유는 자료 기준으로 break를 해 주지 않으면 4번 학생 기준으로 3번과 비교해보면 2학년, 3학년 때 같은 반이므로 cnt가 4가 됨!!!
     */
    private static int solution(int n, int[][] arr) {
        int [] cnt = new int[n+1];
        int answer = 1;
        for(int i=1;i<=n;i++) { // 비교할 첫 번째 학생
            for(int j=1;j<=n;j++) { // 비교할 두 번째 학생
                for(int k=1;k<=5;k++) { // k학년 때 같은 반이었는지 비교
                    if (i!=j && arr[i][k] == arr[j][k]) {
                        cnt[i]++;
                        cnt[j]++;
                        break; // 이미 i번 학생과 j번 학생이 같은 반인 건 알았기 때문
                    }
                }
            }
        }

        for(int l=2;l<=n;l++) {
            if (cnt[l] > cnt[answer]) answer = l;
        }

        return answer;
    }
}
