package inflearn.section3_array;

import java.util.*;
import java.io.*;

public class problem12_멘토링_important {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int [][] arr = new int[m+1][n+1];

        StringTokenizer st;
        for(int i=1;i<=m;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, m, arr));
    }

    /**
     * 3 4 1 2 > 3번 학생이 1등, 4번 학생이 2등, ...
     */
    private static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for(int i=1;i<=n;i++) { // i번 학생이 멘토,
            for(int j=1;j<=n;j++) { // j번 학생이 멘티인 조합이 가능한가?
                boolean flag = true;

                if (i == j) {
                    flag = false;
                    continue;
                }

                // k번째 테스트에서 i번 학생이 더 등수가 높았는지 확인
                for(int k=1;k<=m;k++) {
                    int iRank = -1;
                    int jRank = -1;

                    for(int l=1;l<=n;l++) {
                        // 1. i번 학생은 k번째 테스트에서 몇 등인지 확인
                        if (arr[k][l] == i) iRank = l;

                        // 2. j번 학생은 k번째 테스트에서 몇 등인지 확인
                        if (arr[k][l] == j) jRank = l;

                        if (iRank != -1 && jRank != -1) break;
                    }

                    // 3. 1과 2 비교, 1 > 2이면 false 후 break!!!
                    if (iRank > jRank) {
                        flag = false;
                        break;
                    }
                }

                if (flag) answer++;
            }
        }
        return answer;
    }
}
