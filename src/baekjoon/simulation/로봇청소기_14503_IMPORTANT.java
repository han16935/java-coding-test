package baekjoon.simulation;

import java.util.*;
import java.io.*;

public class 로봇청소기_14503_IMPORTANT {
    static int n, m, d;
    static int answer;
    static int currentN, currentM;
    static int[][] arr;
    static int[] dn = {-1, 0, 1, 0}; // 세로
    static int[] dm = {0, 1, 0, -1}; // 가로

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        st = new StringTokenizer(br.readLine());
        currentN = Integer.parseInt(st.nextToken());
        currentM = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (arr[currentN][currentM] == 0) {
                arr[currentN][currentM] = 2;
                answer++;
            }

            // 청소되지 않은 빈 칸 없는 경우
            if (isAroundRoomAllBlockOrCleaned()) {
                int backWardD = getBackWardDirection();
                int tmpN = currentN + dn[backWardD];
                int tmpM = currentM + dm[backWardD];

                // 후진 불가 시 break
                if (arr[tmpN][tmpM] == 1) break;

                    // 후진 가능 시 (청소 X / 청소 O) 한 칸 후진
                else {
                    currentN = tmpN;
                    currentM = tmpM;
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    // 반시계 방향 90 회전 (d--)
                    updateDirection();
                    int tmpN = currentN + dn[d];
                    int tmpM = currentM + dm[d];

                    // 앞 칸 청소 X 시 한 칸 전진
                    if (isAvailableBlock(tmpN, tmpM) && arr[tmpN][tmpM] == 0) {
                        currentN = tmpN;
                        currentM = tmpM;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static boolean isAroundRoomAllBlockOrCleaned() {
        for (int i = 0; i < 4; i++) {
            int tmpN = currentN + dn[i];
            int tmpM = currentM + dm[i];
            if (isAvailableBlock(tmpN, tmpM) && arr[tmpN][tmpM] == 0) return false;
        }
        return true;
    }

    static boolean isAvailableBlock(int tmpN, int tmpM) {
        if (tmpN < 0 || tmpN >= n || tmpM < 0 || tmpM >= m) return false;
        else return true;
    }

    static void updateDirection() {
        int nextD = d - 1;
        if (nextD == -1) d = 3;
        else d = nextD;
    }

    static int getBackWardDirection() {
        if (d < 2) return d + 2;
        else return d - 2;
    }
}
