package inflearn.section6_sorting_searching;

import java.util.*;
import java.io.*;

public class problem4_LRU_important {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] tasks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tasks[i] = Integer.parseInt(st.nextToken());
        }

        int[] cache = new int[s];

        solution(s, n, cache, tasks);
    }

    /**
     * cache miss > 자신보다 앞 칸의 task를 뒤 칸으로 옮기기
     * cache hit > 무조건 뒤 칸으로 옮기지 않고, 기존 task의 index부터 옮기기!
     *     - 기존 풀이에서는 그냥 옮겨서 case 하나 나감;;
     *
     *
     */
    private static void solution(int s, int n, int[] cache, int[] tasks) {

        boolean [] isCached = new boolean[101];

        for (int i = 0; i < n; i++) {
            int task = tasks[i];
            if (isCached[task]) {
                int cacheIndex=-1;

                // cache hit index 찾기
                for(int j=0;j<n;j++) {
                    if (cache[j] == task) {
                        cacheIndex = j;
                        break;
                    }
                }

                for(int k=cacheIndex-1;k>=0;k--) {
                    cache[k+1] = cache[k];
                }

                cache[0] = task;
            }

            // Cache Miss
            else {
                // 맨 뒤 요소는 캐시에서 사라지므로
                isCached[cache[s-1]] = false;

                for (int j = s - 2; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }

                cache[0] = task;
                isCached[task] = true;
            }

        }

        for(int k=0;k<s;k++) {
            System.out.print(cache[k] + " ");
        }
    }
}