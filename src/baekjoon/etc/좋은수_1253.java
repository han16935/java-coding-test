package baekjoon.etc;

import java.util.*;
import java.io.*;

public class 좋은수_1253 {
    static int n, answer;
    static int [] arr;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int j=0;j<n;j++) {
            int lt = 0;
            int rt = n - 1;
            int target = arr[j];

            while (lt < rt) {
                if (arr[lt] + arr[rt] == target) {

                    // 문제 내 어떤 수가 다른 두 수 두 개의 합으로 나타낼 수 있어야 하므로
                    // 더해지는 수가 arr[k] 면 안 됨
                    if (lt == j) {
                        lt++;
                    }

                    else if (rt == j) {
                        rt--;
                    }

                    else {
                        answer++;
                        break;
                    }
                }

                else if (arr[lt] + arr[rt] < target) {
                    lt++;
                }

                else if (arr[lt] + arr[rt] > target) {
                    rt--;
                }
            }
        }

        System.out.println(answer);
    }
}
