package inflearn.section2_array;

import java.io.*;
import java.util.*;

public class problem7_점수계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n+1];
        int i = 1;
        arr[0] = 0;
        while(st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        int answer = 0;
        int score = 0;
        for (int i=1;i<=n;i++) {
            if (arr[i] == 1) {
                score++;
                answer+=score;
            }

            if (arr[i] == 0) {
                score = 0;
            }
        }
        return answer;
    }
}
