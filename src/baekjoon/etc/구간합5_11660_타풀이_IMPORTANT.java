package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 구간합5_11660_타풀이_IMPORTANT {

    static int n, m;
    static int[][] arr;
    static int[][] sumArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        sumArr = new int[n + 1][n + 1];

        // arr 계산
        for (int row = 1; row <= n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= n; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 2~n 부분합 배열 초기화
        for (int x = 1; x<=n;x++) {
            for (int y = 1; y<=n;y++) {
                sumArr[x][y] = sumArr[x - 1][y] + sumArr[x][y - 1] + arr[x][y] - sumArr[x - 1][y - 1];
            }
        }

        for (int cnt=0;cnt<m;cnt++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2) {
                bw.write(String.valueOf(arr[x1][y1] + "\n"));
                continue;
            }

            bw.write(String.valueOf(sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1]) + "\n");
        }

        bw.flush();
    }
}
