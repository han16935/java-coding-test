package inflearn.section3_array;

import java.io.*;
import java.util.*;

public class problem11_임시반장 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int answer = 1;
        int [] isDuplicateInGrade = new int[10]; // 1반부터 9반까지 존재하므로, 같은 숫자가 두 번 이상 잇엇으면
        int [] duplicateCnt = new int[n+1]; // 특정 학년, 같은 반에 친구 잇엇으면 +1
        for (int grade = 0; grade < 5; grade ++) {
            boolean isDuplicateClass = false;
            for (int studentNum = 0; studentNum < n; studentNum++) {
                // 1. 같은 반 다닌 친구 있는 지 찾기
                isDuplicateInGrade[arr[studentNum][grade]]++;
                if (isDuplicateInGrade[arr[studentNum][grade]] > 1) isDuplicateClass = true;
            }


            // 1-1. 같은 반 다니는 친구가 잇는 지 확인
            if (isDuplicateClass) {
                for(int i=0;i<10;i++) {
                    if (isDuplicateInGrade[i] > 1) {
                        for(int j=0;j<n;j++) {
                            if (arr[j][grade] == i) {
                                duplicateCnt[j]++;
                            }
                        }
                    }
                }
            }

            // 2. isDuplicateInGrade 초기화
            for (int i=1;i<10;i++) {
                isDuplicateInGrade[i] = 0;
            }
        }

        for(int i=2;i<=n;i++) {
            if (duplicateCnt[i] > duplicateCnt[answer]) answer = i;
        }

        return answer + 1;
    }
}
