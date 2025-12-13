package baekjoon.dfs;

import java.util.*;
import java.io.*;

public class 사다리조작_15684_IMPORTANT {

    static int n, m, h;
    static int answer = Integer.MAX_VALUE;
    static int [][] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h + 2][n + 2];

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int commaLine = Integer.parseInt(st.nextToken());
            int startRowLine = Integer.parseInt(st.nextToken());
            arr[commaLine][startRowLine] = 1; // commaLine번째 점선에서 startRowLine ~ startRowLine + 1 사이 사다리 존재
        }

        // 설치하는 최대 사다리 수 0~3
        for (int maxBridge = 0; maxBridge <= 3; maxBridge++) {
            dfs (0, maxBridge, 1);
        }

        System.out.println(-1);
    }

    static void dfs (int bridgeCount, int maxBridge, int currentRow) {

        // 설치한 사다리 수가 최솟값을 넘거나, 최대 사다리 수 넘기면 중단
        if (bridgeCount > maxBridge || bridgeCount > answer) return;

        // i번째 길에서 i로 나올 수 잇는 경우
        if (isAnswerCase()) {
            answer = Math.min(bridgeCount, maxBridge);
            System.out.println(answer);
            System.exit(0);
        }

        for (int startRow = currentRow; startRow <= h; startRow++) {
            for (int col=1;col<=n;col++) {
                // 현 위치 시작하는 사다리,
                // 현 위치 왼쪽에서 현 위치로 오는 사다리,
                // 현 위치에서 오른쪽으로 사다리 만들면 그 옆에도 사다리 잇는 지 확인
                if (arr[startRow][col] == 0 && arr[startRow][col-1] == 0 && arr[startRow][col + 1] == 0) {
                    arr[startRow][col] = 1;
                    dfs (bridgeCount + 1, maxBridge, startRow);
                    arr[startRow][col] = 0;
                }
            }
        }
    }

    static boolean isAnswerCase() {
        for (int col=1;col<=n;col++) {
            int currentPos = col;
            int currentRow = 1;

            while (currentRow < h + 1) {
                if (arr[currentRow][currentPos - 1] == 1) currentPos--;

                else if (arr[currentRow][currentPos] == 1) currentPos++;

                currentRow++;
            }

            if (currentPos != col) return false;
        }
        return true;
    }
}
