package inflearn.section2_array;

import java.io.*;
import java.util.*;

public class problem3_가위바위보 {

    private static void solution(int n, int[] a, int[] b) {
        for(int i=0;i<n;i++) {
            System.out.println(RSP.getWinner(a[i], b[i]));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] a = new int[n];
        int i = 0;
        while(st.hasMoreTokens()) {
            a[i++] = Integer.parseInt(st.nextToken());
        }
        i = 0;

        st = new StringTokenizer(br.readLine());
        int [] b = new int[n];
        while(st.hasMoreTokens()) {
            b[i++] = Integer.parseInt(st.nextToken());
        }

        solution(n, a, b);
    }

    private enum RSP {
        ROCK(1, 2),
        SCISSOR(2, 3),
        PAPER(3, 1);

        private final int turnNum;
        private final int loseNum;

        RSP(int turnNum, int loseNum) {
            this.turnNum = turnNum;
            this.loseNum = loseNum;
        }

        // 이 함수 결과로 나오는 값
        public static char getWinner(int a, int b) {
            if (a == b) return 'D';
            for (RSP rspType : RSP.values()) {
                 if (rspType.turnNum == a) {
                     return rspType.loseNum == b ? 'B' : 'A';
                 }
            }
            return 'X';
        }
    }
}
