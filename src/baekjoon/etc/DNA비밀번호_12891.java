package baekjoon.etc;

import java.util.*;
import java.io.*;

public class DNA비밀번호_12891 {
    static int n, m, answer; // 전체 길이, 부분문자열 길이
    static String dnaString; // 전체 문자열
    static int[] requiredDnaArr = new int[4]; // A, C, G, T 순 저장
    static int[] substringDnaArr = new int[4]; // A, C, G, T 순 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dnaString = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            requiredDnaArr[i] = Integer.parseInt(st.nextToken());
        }

        // substringDnaArr 초기화
        for (int i = 0; i < m; i++) {
            if (dnaString.charAt(i) == 'A') substringDnaArr[0]++;
            if (dnaString.charAt(i) == 'C') substringDnaArr[1]++;
            if (dnaString.charAt(i) == 'G') substringDnaArr[2]++;
            if (dnaString.charAt(i) == 'T') substringDnaArr[3]++;
        }

        if (isAvailableSubstring()) answer++;

        for (int start = 1; start + m - 1 < n; start++) {

            if (dnaString.charAt(start - 1) == 'A') substringDnaArr[0]--;
            if (dnaString.charAt(start - 1) == 'C') substringDnaArr[1]--;
            if (dnaString.charAt(start - 1) == 'G') substringDnaArr[2]--;
            if (dnaString.charAt(start - 1) == 'T') substringDnaArr[3]--;

            if (dnaString.charAt(start + m - 1) == 'A') substringDnaArr[0]++;
            if (dnaString.charAt(start + m - 1) == 'C') substringDnaArr[1]++;
            if (dnaString.charAt(start + m - 1) == 'G') substringDnaArr[2]++;
            if (dnaString.charAt(start + m - 1) == 'T') substringDnaArr[3]++;

            if (isAvailableSubstring()) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isAvailableSubstring() {
        return substringDnaArr[0] >= requiredDnaArr[0] && substringDnaArr[1] >= requiredDnaArr[1]
                && substringDnaArr[2] >= requiredDnaArr[2] && substringDnaArr[3] >= requiredDnaArr[3];

    }
}
