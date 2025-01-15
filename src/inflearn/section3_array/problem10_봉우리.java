package inflearn.section3_array;

import java.io.*;
import java.util.*;

public class problem10_봉우리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        int j = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
            j = 0;
        }
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currentPosition = arr[i][j];
                boolean isMountain = true;
                for (int k = 0; k < 4; k++) {
                    int ifX = j + dx[k];
                    int ifY = i + dy[k];

                    if (ifX < 0 || n == ifX) continue;
                    if (ifY < 0 || n == ifY) continue;

                    int ifPosition = arr[ifY][ifX];
                    if (currentPosition <= ifPosition) {
                        isMountain = false;
                        break;
                    }
                }
                if (isMountain) answer++;
            }
        }
        return answer;
    }
}

