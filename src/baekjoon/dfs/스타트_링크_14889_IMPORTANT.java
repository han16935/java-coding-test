package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class 스타트_링크_14889_IMPORTANT {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int [][] arr;
    static boolean [] isFirstTeam;

    public static void main (String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        isFirstTeam = new boolean[n+1];
        for(int i=0;i<=n;i++) {
            arr[i][0] = 0;
            arr[0][i] = 0;
        }

        StringTokenizer st;
        for(int col=1;col<=n;col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= n; row++) {
                arr[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        solution(1, 0);

        System.out.println(answer);
    }

    static void solution(int currentNumber, int chosenCount) {

        if (chosenCount == n/2) {
            int diff = calculateTeamScore();
            answer = Math.min(answer, diff);
            return;
        }

        if (currentNumber > n || chosenCount > n/2) return;

        isFirstTeam[currentNumber] = true;
        solution(currentNumber+1, chosenCount+1);
        isFirstTeam[currentNumber] = false;
        solution(currentNumber+1, chosenCount);
    }

    static int calculateTeamScore() {
        int firstTeamScore = 0;
        int secondTeamScore = 0;
        for (int firstMember = 1; firstMember < n; firstMember++) {
            for (int secondMember = firstMember + 1; secondMember <= n; secondMember++) {

                if (isFirstTeam[firstMember] == true && isFirstTeam[secondMember] == true) {
                    firstTeamScore += arr[firstMember][secondMember];
                    firstTeamScore += arr[secondMember][firstMember];
                }

                if (isFirstTeam[firstMember] == false && isFirstTeam[secondMember] == false) {
                    secondTeamScore += arr[firstMember][secondMember];
                    secondTeamScore += arr[secondMember][firstMember];
                }
            }
        }
        return Math.abs(firstTeamScore - secondTeamScore);
    }
}
