package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 구간합5_11660 {

    static int n, m;
    static int [][] arr;
    static int [][] arrSum;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        arrSum = new int[n+1][n+1];

        for (int row=1;row<=n;row++) {
            st = new StringTokenizer(br.readLine());
            for (int col=1;col<=n;col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
                arrSum[row][col] = arrSum[row][col-1] + arr[row][col];
            }
        }

        for (int cnt=0;cnt<m;cnt++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2) {
                bw.write(String.valueOf(arr[x1][y1]) + "\n");
                continue;
            }

            int sum = 0;
            for (int xRange = x1; xRange<=x2;xRange++) {
               sum += arrSum[xRange][y2] - arrSum[xRange][y1-1];
            }
            bw.write(String.valueOf(sum) + "\n");
        }

        bw.flush();
    }
}
